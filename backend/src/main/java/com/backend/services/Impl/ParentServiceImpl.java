package com.backend.services.Impl;

import com.backend.dto.ParentDto;
import com.backend.entities.Child;
import com.backend.entities.Parent;
import com.backend.repositories.ChildRepository;
import com.backend.repositories.ParentRepository;
import com.backend.services.ParentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ParentServiceImpl implements ParentService {
    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;

    public ParentServiceImpl(ParentRepository parentRepository, ChildRepository childRepository) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
    }

    /**
     * get request parent page list then convert to ParentDto
     * @param page page number
     * @param pageSize item per page
     * @return parent data transfer object
     */
    @Override
    public List<ParentDto> getParents(int page, int pageSize) {
        List<Parent> parents = this.parentRepository.getParents(page, pageSize);
        Map<Long, Long> parentIdWithTotalPaidMapper = parents.stream()
                .collect(Collectors.toMap(Parent::getId, x -> this.childRepository.getChildByParentId(x.getId())
                        .stream()
                        .mapToLong(Child::getPaidAmount)
                        .sum()));
        return parents.stream()
                .map(x -> new ParentDto(x.getId(), x.getSender(), x.getReceiver(), x.getTotalAmount(), parentIdWithTotalPaidMapper.get(x.getId())))
                .toList();
    }
}
