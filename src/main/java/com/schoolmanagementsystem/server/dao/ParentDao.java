package com.schoolmanagementsystem.server.dao;

import java.util.List;

import com.schoolmanagementsystem.server.models.Parent;

public interface ParentDao {
    List<Parent> getAllParents();
    Parent findByParentId(Integer parentId);
    Parent saveParent(Parent parent);
    void deleteParent(Integer parentId);
    Parent updateParent(Parent parent);
}
