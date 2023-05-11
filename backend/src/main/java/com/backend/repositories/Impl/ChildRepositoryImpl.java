package com.backend.repositories.Impl;

import com.backend.dto.ResourceJson;
import com.backend.entities.Child;
import com.backend.repositories.BaseRepository;
import com.backend.repositories.ChildRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ChildRepositoryImpl extends BaseRepository<Child> implements ChildRepository {
    public ChildRepositoryImpl() {
        super("Child.json");
    }

    @Override
    public List<Child> getChildByParentId(Long id) {
        return this.getAllFromResources().stream().filter(x -> Objects.equals(x.getParentId(), id)).toList();
    }

    @Override
    protected TypeReference<ResourceJson<Child>> getTypeReference() {
        return new TypeReference<>() {
        };
    }
}
