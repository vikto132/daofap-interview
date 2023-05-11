package com.backend.repositories;

import com.backend.dto.Page;
import com.backend.entities.Parent;

import java.util.List;

public interface ParentRepository {
    Page<Parent> getParents(int page, int pageSize);

    Parent getParent(Long id);
}
