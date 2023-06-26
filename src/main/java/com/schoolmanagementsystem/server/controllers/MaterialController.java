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

import com.schoolmanagementsystem.server.models.Material;
import com.schoolmanagementsystem.server.services.MaterialServiceImpl;

@RestController
@RequestMapping("/api/v1/material")
public class MaterialController {
        private MaterialServiceImpl materialServiceImpl;

    public MaterialController(MaterialServiceImpl materialServiceImpl){
        this.materialServiceImpl = materialServiceImpl;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Material>> getAllMaterials() {
        List<Material> materials = materialServiceImpl.getAllMaterials();
        return new ResponseEntity<>(materials, HttpStatus.OK);
    }

    @GetMapping("get/{materialId}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Integer materialId) {
        Material material = materialServiceImpl.getMaterialById(materialId);
        if (material != null) {
            return new ResponseEntity<>(material, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        Material createdMaterial = materialServiceImpl.createMaterial(material);
        return new ResponseEntity<Material>(createdMaterial, HttpStatus.CREATED);
    }

    @PutMapping("put/{materialId}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Integer materialId, @RequestBody Material material) {
        Material existingMaterial = materialServiceImpl.getMaterialById(materialId);
        if (existingMaterial != null) {
            material.setMaterialId(materialId);
            Material updatedMaterial = materialServiceImpl.updateMaterial(material);
            return new ResponseEntity<>(updatedMaterial, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("delete/{materialId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer materialId) {
        Material material = materialServiceImpl.getMaterialById(materialId);
        if (material != null) {
            materialServiceImpl.deleteMaterial(materialId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
