package com.schoolmanagementsystem.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.server.dao.TmcDaoImpl;
import com.schoolmanagementsystem.server.models.Tmc;

@Service
public class TmcServiceImpl implements TmcService {
    private TmcDaoImpl tmcDaoImpl;

    public TmcServiceImpl(TmcDaoImpl tmcDaoImpl) {
        this.tmcDaoImpl = tmcDaoImpl;
    }

    @Override
    public Tmc createTmc(Tmc tmc) {
        return tmcDaoImpl.saveTmc(tmc);
    }

    @Override
    public Tmc getTmcById(Integer tmcId) {
        return tmcDaoImpl.findByTmcId(tmcId);
    }

    @Override
    public void deleteTmc(Integer tmcId) {
        tmcDaoImpl.deleteTmc(tmcId);
    }

    @Override
    public List<Tmc> getAllTmcs() {
        return tmcDaoImpl.getAllTmcs();
    }

    @Override
    public Tmc updateTmc(Tmc tmc) {
        return tmcDaoImpl.updateTmc(tmc);
    }
}
