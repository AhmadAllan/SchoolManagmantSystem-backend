package com.schoolmanagementsystem.server.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.server.dao.StudentDaoImpl;
import com.schoolmanagementsystem.server.dao.MarkDaoImpl;
import com.schoolmanagementsystem.server.dao.MaterialDaoImpl;
import com.schoolmanagementsystem.server.models.Student;
import com.schoolmanagementsystem.server.models.Mark;
import com.schoolmanagementsystem.server.models.Material;

@Service
public class MarkServiceImpl implements MarkService {
    private final MarkDaoImpl markDaoImpl;
    private final StudentDaoImpl studentDaoImpl;
    private final MaterialDaoImpl materialDaoImpl;

    public MarkServiceImpl(MarkDaoImpl markDaoImpl, StudentDaoImpl studentDaoImpl, MaterialDaoImpl materialDaoImpl){
        this.markDaoImpl = markDaoImpl;
        this.studentDaoImpl = studentDaoImpl;
        this.materialDaoImpl = materialDaoImpl;
    }
    @Override
    public Mark createMark(Mark mark) {
        Student student = studentDaoImpl.findByStudentId(mark.getStudentId());
        Material material = materialDaoImpl.findByMaterialId(mark.getMaterialId());
        if (student != null && material != null) {
            mark.setStudent(student);
            mark.setMaterial(material);
            return markDaoImpl.saveMark(mark);
        } else {
            System.out.println("material and student not found");
            return null;
        }
    }

    @Override
    public Mark getMarkById(Integer markId) {
        return markDaoImpl.findByMarkId(markId);
    }

    @Override
    public void deleteMark(Integer markId) {
        markDaoImpl.deleteMark(markId);
    }

    @Override
    public List<Mark> getAllMarks() {
        return markDaoImpl.getAllMarks();
    }

    @Override
    public Mark updateMark(Mark mark) {
        return markDaoImpl.updateMark(mark);
    }
}
