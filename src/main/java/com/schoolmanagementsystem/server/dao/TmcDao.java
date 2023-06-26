package com.schoolmanagementsystem.server.dao;

import java.util.List;

import com.schoolmanagementsystem.server.models.Tmc;

public interface TmcDao {
    
    List<Tmc> getAllTmcs();
    Tmc findByTmcId(Integer tmcId);
    Tmc saveTmc(Tmc tmc);
    void deleteTmc(Integer tmcId);
    Tmc updateTmc(Tmc tmc);
}
