package com.schoolmanagementsystem.server.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.server.models.Parent;
import com.schoolmanagementsystem.server.services.ParentServiceImpl;

@RestController
@RequestMapping("/api/v1/parent")
public class ParentController {
    private ParentServiceImpl parentServiceImpl;

    public ParentController(ParentServiceImpl parentServiceImpl){
        this.parentServiceImpl = parentServiceImpl;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Parent>> getAllParents() {
        List<Parent> parents = parentServiceImpl.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.OK);
    }

    @GetMapping("get/{parentId}")
    public ResponseEntity<Parent> getParentById(@PathVariable Integer parentId) {
        Parent parent = parentServiceImpl.getParentById(parentId);
        if (parent != null) {
            return new ResponseEntity<>(parent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Parent> createParent(@RequestBody Parent parent) {
        Parent createdParent = parentServiceImpl.createParent(parent);
        return new ResponseEntity<Parent>(createdParent, HttpStatus.CREATED);
    }

    @PutMapping("put/{parentId}")
    public ResponseEntity<Parent> updateParent(@PathVariable Integer parentId, @RequestBody Parent parent) {
        Parent existingParent = parentServiceImpl.getParentById(parentId);
        if (existingParent != null) {
            parent.setParentId(parentId);
            Parent updatedParent = parentServiceImpl.updateParent(parent);
            return new ResponseEntity<>(updatedParent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("delete/{parentId}")
    public ResponseEntity<Void> deleteParent(@PathVariable Integer parentId) {
        Parent parent = parentServiceImpl.getParentById(parentId);
        if (parent != null) {
            parentServiceImpl.deleteParent(parentId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
