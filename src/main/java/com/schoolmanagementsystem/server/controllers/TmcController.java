package com.schoolmanagementsystem.server.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.schoolmanagementsystem.server.models.Tmc;
import com.schoolmanagementsystem.server.services.TmcServiceImpl;

@RestController
@RequestMapping("/api/v1/tmc")
public class TmcController {
    private TmcServiceImpl tmcServiceImpl;

    public TmcController(TmcServiceImpl tmcServiceImpl) {
        this.tmcServiceImpl = tmcServiceImpl;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Tmc>> getAllTmcs() {
        List<Tmc> tmcs = tmcServiceImpl.getAllTmcs();
        return new ResponseEntity<>(tmcs, HttpStatus.OK);
    }

    @GetMapping("get/{tmcId}")
    public ResponseEntity<Tmc> getTmcById(@PathVariable Integer tmcId) {
        Tmc tmc = tmcServiceImpl.getTmcById(tmcId);
        if (tmc != null) {
            return new ResponseEntity<>(tmc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Tmc> createTmc(@RequestBody Tmc tmc) {
        Tmc createdTmc = tmcServiceImpl.createTmc(tmc);
        return new ResponseEntity<>(createdTmc, HttpStatus.CREATED);
    }

    @PutMapping("put/{tmcId}")
    public ResponseEntity<Tmc> updateTmc(@PathVariable Integer tmcId, @RequestBody Tmc tmc) {
        Tmc existingTmc = tmcServiceImpl.getTmcById(tmcId);
        if (existingTmc != null) {
            tmc.setTmcId(tmcId);
            Tmc updatedTmc = tmcServiceImpl.updateTmc(tmc);
            return new ResponseEntity<>(updatedTmc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{tmcId}")
    public ResponseEntity<Void> deleteTmc(@PathVariable Integer tmcId) {
        Tmc tmc = tmcServiceImpl.getTmcById(tmcId);
        if (tmc != null) {
            tmcServiceImpl.deleteTmc(tmcId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
