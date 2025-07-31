package com.traning.AcademicTraning.service;

import com.traning.AcademicTraning.dto.CourseDto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.traning.AcademicTraning.entity.Courses;
import com.traning.AcademicTraning.exception.CourseNotFoundException;



public interface CourseService {
	List<CourseDto> getCourses();
    CourseDto getCourse(long courseId) throws CourseNotFoundException;
    CourseDto addCourse(CourseDto courseDto);
    CourseDto updateCourse(CourseDto courseDto) throws CourseNotFoundException;
    void deleteCourse(long courseId) throws CourseNotFoundException;

}