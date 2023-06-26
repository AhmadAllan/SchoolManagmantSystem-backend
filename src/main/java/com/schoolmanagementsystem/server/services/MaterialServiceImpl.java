package com.schoolmanagementsystem.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.server.dao.MaterialDaoImpl;
import com.schoolmanagementsystem.server.models.Material;

@Service
public class MaterialServiceImpl implements MaterialService {
    private MaterialDaoImpl materialDaoImpl;

    public MaterialServiceImpl(MaterialDaoImpl materialDaoImpl){
        this.materialDaoImpl = materialDaoImpl;
    }
    @Override
    public Material createMaterial(Material material) {
        return materialDaoImpl.saveMaterial(material);
    }

    @Override
    public Material getMaterialById(Integer materialId) {
        return materialDaoImpl.findByMaterialId(materialId);
    }

    @Override
    public void deleteMaterial(Integer materialId) {
        materialDaoImpl.deleteMaterial(materialId);
    }

    @Override
    public List<Material> getAllMaterials() {
        return materialDaoImpl.getAllMaterials();
    }

    @Override
    public Material updateMaterial(Material material) {
        return materialDaoImpl.updateMaterial(material);
    }
}
