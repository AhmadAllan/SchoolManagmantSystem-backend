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

import com.schoolmanagementsystem.server.models.Mark;
import com.schoolmanagementsystem.server.services.MarkServiceImpl;

@RestController
@RequestMapping("/api/v1/mark")
public class MarkController {
    private MarkServiceImpl markServiceImpl;

    public MarkController(MarkServiceImpl markServiceImpl) {
        this.markServiceImpl = markServiceImpl;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Mark>> getAllMarks() {
        List<Mark> marks = markServiceImpl.getAllMarks();
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }

    @GetMapping("get/{markId}")
    public ResponseEntity<Mark> getMarkById(@PathVariable Integer markId) {
        Mark mark = markServiceImpl.getMarkById(markId);
        if (mark != null) {
            return new ResponseEntity<>(mark, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Mark> createMark(@RequestBody Mark mark) {
        Mark createdMark = markServiceImpl.createMark(mark);
        return new ResponseEntity<Mark>(createdMark, HttpStatus.CREATED);
    }

    @PutMapping("put/{markId}")
    public ResponseEntity<Mark> updateMark(@PathVariable Integer markId, @RequestBody Mark mark) {
        Mark existingMark = markServiceImpl.getMarkById(markId);
        if (existingMark != null) {
            mark.setMarkId(markId);
            Mark updatedMark = markServiceImpl.updateMark(mark);
            return new ResponseEntity<>(updatedMark, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{markId}")
    public ResponseEntity<Void> deleteMark(@PathVariable Integer markId) {
        Mark mark = markServiceImpl.getMarkById(markId);
        if (mark != null) {
            markServiceImpl.deleteMark(markId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
