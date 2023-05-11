package com.backend.repositories;

import com.backend.entities.Child;

import java.util.List;

public interface ChildRepository {
    List<Child> getChildByParentId(Long id);
}
