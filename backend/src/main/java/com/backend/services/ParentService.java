package com.backend.services;

import com.backend.dto.ParentDto;

import java.util.List;

public interface ParentService {
    List<ParentDto> getParents(int page, int pageSize);
}
