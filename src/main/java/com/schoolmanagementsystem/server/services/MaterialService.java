package com.schoolmanagementsystem.server.services;

import java.util.List;

import com.schoolmanagementsystem.server.models.Material;

public interface MaterialService {
    Material createMaterial(Material material);

    Material getMaterialById(Integer materialId);

    void deleteMaterial(Integer materialId);

    List<Material> getAllMaterials();

    Material updateMaterial(Material material);
}