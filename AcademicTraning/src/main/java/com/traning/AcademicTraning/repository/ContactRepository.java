package com.traning.AcademicTraning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traning.AcademicTraning.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
