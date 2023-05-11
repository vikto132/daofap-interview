package com.backend.services.Impl;

import com.backend.dto.ChildDto;
import com.backend.entities.Parent;
import com.backend.repositories.ChildRepository;
import com.backend.repositories.ParentRepository;
import com.backend.services.ChildService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {
    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;

    public ChildServiceImpl(ParentRepository parentRepository, ChildRepository childRepository) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
    }

    /**
     * Get all child object have provided parentId then convert to ChildDto
     * @param parentId id of parent of list child request
     * @return list child data transfer object
     */
    @Override
    public List<ChildDto> getListChildByParentId(Long parentId) {
        Parent parent = this.parentRepository.getParent(parentId);
        return this.childRepository.getChildByParentId(parentId)
                .stream()
                .sorted((a,b) -> (int) (a.getId() - b.getId()))
                .map(x -> new ChildDto(x.getId(), parent.getSender(), parent.getReceiver(), parent.getTotalAmount(), x.getPaidAmount()))
                .toList();
    }
}
