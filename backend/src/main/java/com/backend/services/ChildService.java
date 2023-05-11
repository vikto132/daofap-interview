package com.backend.services;

import com.backend.dto.ChildDto;

import java.util.List;

public interface ChildService {
    List<ChildDto> getListChildByParentId(Long parentId);
}
