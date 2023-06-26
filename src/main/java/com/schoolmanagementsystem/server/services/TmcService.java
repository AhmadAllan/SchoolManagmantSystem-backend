package com.schoolmanagementsystem.server.services;

import java.util.List;

import com.schoolmanagementsystem.server.models.Tmc;

public interface TmcService {
    Tmc createTmc(Tmc tmc);

    Tmc getTmcById(Integer tmcId);

    void deleteTmc(Integer tmcId);

    List<Tmc> getAllTmcs();

    Tmc updateTmc(Tmc tmc);
}
