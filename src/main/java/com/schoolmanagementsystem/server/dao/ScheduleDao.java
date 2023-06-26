package com.schoolmanagementsystem.server.dao;

import java.util.List;

import com.schoolmanagementsystem.server.models.Schedule;

public interface ScheduleDao {
    List<Schedule> getAllSchedules();

    Schedule findByScheduleId(Integer scheduleId);

    Schedule saveSchedule(Schedule schedule);

    void deleteSchedule(Integer scheduleId);

    Schedule updateSchedule(Schedule schedule);
}
