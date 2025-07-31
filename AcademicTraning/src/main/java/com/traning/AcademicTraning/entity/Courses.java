package com.traning.AcademicTraning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Courses")
public class Courses {


	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;

	private String title;
	private String description;

}
