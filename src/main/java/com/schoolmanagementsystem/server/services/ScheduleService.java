package com.schoolmanagementsystem.server.services;

import java.util.List;

import com.schoolmanagementsystem.server.models.Schedule;

public interface ScheduleService {
    Schedule createSchedule(Schedule schedule);

    Schedule getScheduleById(Integer scheduleId);

    void deleteSchedule(Integer scheduleId);

    List<Schedule> getAllSchedules();

    Schedule updateSchedule(Schedule schedule);
}
