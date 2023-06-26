package com.schoolmanagementsystem.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.server.dao.ClassroomDaoImpl;
import com.schoolmanagementsystem.server.dao.ScheduleDaoImpl;
import com.schoolmanagementsystem.server.models.Classroom;
import com.schoolmanagementsystem.server.models.Schedule;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleDaoImpl scheduleDaoImpl;
    private final ClassroomDaoImpl classroomDaoImpl;

    public ScheduleServiceImpl(ScheduleDaoImpl scheduleDaoImpl, ClassroomDaoImpl classroomDaoImpl){
        this.scheduleDaoImpl = scheduleDaoImpl;
        this.classroomDaoImpl = classroomDaoImpl;
    }

    @Override
    public Schedule createSchedule(Schedule schedule) {
        Classroom classroom = classroomDaoImpl.findByClassroomId(schedule.getClassroomId());
        if (classroom != null) {
            schedule.setClassroom(classroom);
            return scheduleDaoImpl.saveSchedule(schedule);
        } else {
            System.out.println("parent not found");
            return null;
        }
    }

    @Override
    public Schedule getScheduleById(Integer scheduleId) {
        return scheduleDaoImpl.findByScheduleId(scheduleId);
    }

    @Override
    public void deleteSchedule(Integer scheduleId) {
        scheduleDaoImpl.deleteSchedule(scheduleId);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleDaoImpl.getAllSchedules();
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        return scheduleDaoImpl.updateSchedule(schedule);
    }
}
