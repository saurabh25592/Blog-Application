package com.traning.AcademicTraning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String email_Id;
	private String address;
	
}
