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

import com.schoolmanagementsystem.server.models.Schedule;
import com.schoolmanagementsystem.server.services.ScheduleServiceImpl;

@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {

    private final ScheduleServiceImpl ScheduleServiceImpl;

    public ScheduleController(ScheduleServiceImpl ScheduleServiceImpl) {
        this.ScheduleServiceImpl = ScheduleServiceImpl;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> Schedules = ScheduleServiceImpl.getAllSchedules();
        return new ResponseEntity<>(Schedules, HttpStatus.OK);
    }

    @GetMapping("get/{ScheduleId}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Integer ScheduleId) {
        Schedule Schedule = ScheduleServiceImpl.getScheduleById(ScheduleId);
        if (Schedule != null) {
            return new ResponseEntity<>(Schedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule Schedule) {
        Schedule createdSchedule = ScheduleServiceImpl.createSchedule(Schedule);
        return new ResponseEntity<Schedule>(createdSchedule, HttpStatus.CREATED);
    }

    @PutMapping("put/{ScheduleId}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Integer ScheduleId, @RequestBody Schedule Schedule) {
        Schedule existingSchedule = ScheduleServiceImpl.getScheduleById(ScheduleId);
        if (existingSchedule != null) {
            Schedule.setScheduleId(ScheduleId);
            Schedule updatedSchedule = ScheduleServiceImpl.updateSchedule(Schedule);
            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Integer scheduleId) {
        Schedule schedule = ScheduleServiceImpl.getScheduleById(scheduleId);
        if (schedule != null) {
            ScheduleServiceImpl.deleteSchedule(scheduleId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
