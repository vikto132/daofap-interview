package com.backend.repositories.Impl;

import com.backend.dto.Page;
import com.backend.dto.ResourceJson;
import com.backend.entities.Parent;
import com.backend.repositories.BaseRepository;
import com.backend.repositories.ParentRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParentRepositoryImpl extends BaseRepository<Parent> implements ParentRepository {

    public ParentRepositoryImpl() {
        super("Parent.json");
    }

    @Override
    public Page<Parent> getParents(int page, int pageSize) {
        List<Parent> parents = this.getAllFromResources()
                .stream()
                .sorted((a, b) -> (int) (a.getId() - b.getId()))
                .toList();
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, parents.size());
        Page<Parent> parentPage = new Page<Parent>();
        parentPage.setData(parents.subList(fromIndex, toIndex));
        parentPage.setTotal(parents.size());
        return parentPage;
    }

    @Override
    public Parent getParent(Long id) {
        return this.getAllFromResources()
                .stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not exist Parent with Id: " + id));
    }

    @Override
    protected TypeReference<ResourceJson<Parent>> getTypeReference() {
        return new TypeReference<>() {
        };
    }
}
