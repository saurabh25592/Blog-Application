package com.traning.AcademicTraning.service.imp;

import com.traning.AcademicTraning.dto.CourseDto;
import com.traning.AcademicTraning.entity.Courses;
import com.traning.AcademicTraning.exception.CourseNotFoundException;
import com.traning.AcademicTraning.repository.CourseRepository;
import com.traning.AcademicTraning.service.CourseService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourseServiceImp implements CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDto> getCourses() {
        log.info("Fetching all courses");
        return courseRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourse(long courseId) throws CourseNotFoundException {
        log.info("Fetching course with ID: {}", courseId);
        Courses course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with ID: " + courseId));
        return convertToDto(course);
    }

    @Override
    public CourseDto addCourse(CourseDto courseDto) {
        log.info("Adding new course");
        courseDto.setId(courseDto.getId()); // ensure new course
        Courses saved = courseRepository.save(convertToEntity(courseDto));
        return convertToDto(saved);
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto) throws CourseNotFoundException {
        log.info("Updating course with ID: {}", courseDto.getId());
        if (courseDto.getId() == null || !courseRepository.existsById(courseDto.getId())) {
            throw new CourseNotFoundException("Cannot update. Course not found with ID: " + courseDto.getId());
        }
        Courses updated = courseRepository.save(convertToEntity(courseDto));
        return convertToDto(updated);
    }

    @Override
    public void deleteCourse(long courseId) throws CourseNotFoundException {
        log.info("Deleting course with ID: {}", courseId);
        if (!courseRepository.existsById(courseId)) {
            throw new CourseNotFoundException("Cannot delete. Course not found with ID: " + courseId);
        }
        courseRepository.deleteById(courseId);
    }

    private CourseDto convertToDto(Courses course) {
        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        return dto;
    }

    private Courses convertToEntity(CourseDto dto) {
        Courses course = new Courses();
        course.setId(dto.getId());
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        return course;
    }
}
