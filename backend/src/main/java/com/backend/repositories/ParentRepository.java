package com.backend.repositories;

import com.backend.entities.Parent;

import java.util.List;

public interface ParentRepository {
    List<Parent> getParents(int page, int pageSize);

    Parent getParent(Long id);
}
