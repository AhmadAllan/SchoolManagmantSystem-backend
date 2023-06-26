package com.schoolmanagementsystem.server.services;

import java.util.List;

import com.schoolmanagementsystem.server.models.Parent;

public interface ParentService {
    Parent createParent(Parent parent);
    Parent getParentById(Integer parentId);
    void deleteParent(Integer parentId);
    List<Parent> getAllParents();
    Parent updateParent(Parent parent);
}
