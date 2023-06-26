package com.schoolmanagementsystem.server.dao;

import java.util.List;

import com.schoolmanagementsystem.server.models.Material;

public interface MaterialDao {
    
    List<Material> getAllMaterials();
    Material findByMaterialId(Integer materialId);
    Material saveMaterial(Material material);
    void deleteMaterial(Integer materialId);
    Material updateMaterial(Material material);
}
