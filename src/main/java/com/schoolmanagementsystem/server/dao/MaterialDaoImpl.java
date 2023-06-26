package com.schoolmanagementsystem.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.server.models.Material;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MaterialDaoImpl implements MaterialDao {
        private EntityManager entityManager;

    public MaterialDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Material> getAllMaterials() {
        TypedQuery<Material> query = entityManager.createQuery("SELECT a FROM Material a", Material.class);
        return query.getResultList();
    }

    @Override
    public Material findByMaterialId(Integer materialId) {
        return entityManager.find(Material.class, materialId);
    }

    @Override
    public Material saveMaterial(Material material) {
        entityManager.persist(material);
        return material;
    }    

    @Override
    public void deleteMaterial(Integer materialId) {
        Material material = entityManager.find(Material.class, materialId);
        if (material != null) {
            entityManager.remove(material);
        }
    }

    @Override
    public Material updateMaterial(Material material) {
        return entityManager.merge(material);
    }
}
