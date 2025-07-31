package com.traning.AcademicTraning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.traning.AcademicTraning.dto.CourseDto;
import com.traning.AcademicTraning.entity.Courses;
import com.traning.AcademicTraning.exception.CourseNotFoundException;
import com.traning.AcademicTraning.service.CourseService;

import ch.qos.logback.core.status.Status;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin("http://localhost:3000")
@Slf4j
@RestController
@RequestMapping("/courses")
public class MyController {

	  @Autowired
	    private CourseService courseService;

	    @GetMapping("/")
	    public List<CourseDto> getCourses() {
	        return courseService.getCourses();
	    }

	    @GetMapping("/{courseId}")
	    public CourseDto getCourse(@PathVariable String courseId) throws NumberFormatException, CourseNotFoundException {
	        return courseService.getCourse(Long.parseLong(courseId));
	    }

	    @PostMapping("/add-courses")
	    public ResponseEntity<CourseDto> addCourse(@Valid @RequestBody CourseDto courseDto) {
	        CourseDto saved = courseService.addCourse(courseDto);
	        return new ResponseEntity<>(saved, HttpStatus.CREATED);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<CourseDto> updateCourse(@Valid @RequestBody CourseDto courseDto) throws CourseNotFoundException {
	        CourseDto updated = courseService.updateCourse(courseDto);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }

	    @DeleteMapping("/{courseId}")
	    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
	        try {
	            courseService.deleteCourse(Long.parseLong(courseId));
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (Exception e) {
	            log.error("Error deleting course", e);
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
}
