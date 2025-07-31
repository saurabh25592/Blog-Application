package com.traning.AcademicTraning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traning.AcademicTraning.dto.ContactDto;
import com.traning.AcademicTraning.service.ContactService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin("http://localhost:3000")
@Slf4j
@RestController
@RequestMapping("/contact")
public class MyContactController {

	@Autowired
    private	ContactService contactService;
	

	@PostMapping("/add-contact")
	public ResponseEntity<ContactDto> addcontact(@Valid @RequestBody ContactDto contactDto) {
	ContactDto	saved=contactService.addcontact(contactDto);
     return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
   
	

}