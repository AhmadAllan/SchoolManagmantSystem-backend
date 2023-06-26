package com.schoolmanagementsystem.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.server.dao.ParentDaoImpl;
import com.schoolmanagementsystem.server.models.Parent;

@Service
public class ParentServiceImpl implements ParentService {
    private ParentDaoImpl parentDaoImpl;

    public ParentServiceImpl(ParentDaoImpl parentDaoImpl){
        this.parentDaoImpl = parentDaoImpl;
    }
    @Override
    public Parent createParent(Parent parent) {
        return parentDaoImpl.saveParent(parent);
    }

    @Override
    public Parent getParentById(Integer parentId) {
        return parentDaoImpl.findByParentId(parentId);
    }

    @Override
    public void deleteParent(Integer parentId) {
        parentDaoImpl.deleteParent(parentId);
    }

    @Override
    public List<Parent> getAllParents() {
        return parentDaoImpl.getAllParents();
    }

    @Override
    public Parent updateParent(Parent parent) {
        return parentDaoImpl.updateParent(parent);
    }
}
