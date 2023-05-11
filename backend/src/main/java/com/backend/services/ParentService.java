package com.backend.services;

import com.backend.dto.Page;
import com.backend.dto.ParentDto;

public interface ParentService {
    Page<ParentDto> getParents(int page, int pageSize);
}
