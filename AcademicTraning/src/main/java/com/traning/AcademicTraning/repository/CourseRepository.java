package com.traning.AcademicTraning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traning.AcademicTraning.entity.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long>  {

}
