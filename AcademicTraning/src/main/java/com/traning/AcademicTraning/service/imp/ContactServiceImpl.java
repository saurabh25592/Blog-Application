package com.traning.AcademicTraning.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traning.AcademicTraning.dto.ContactDto;
import com.traning.AcademicTraning.dto.CourseDto;
import com.traning.AcademicTraning.entity.Contact;
import com.traning.AcademicTraning.entity.Courses;
import com.traning.AcademicTraning.repository.ContactRepository;
import com.traning.AcademicTraning.service.ContactService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

	
	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public ContactDto addcontact(ContactDto contactdtoo) {	
		log.info("adding a new contact");
		 Contact saved = contactRepository.save(convertToEntity(contactdtoo));
		 return convertToDto(saved);
		 
		 
	}
		 
		  public ContactDto convertToDto(Contact contact) {
		        ContactDto dto = new ContactDto();
		        dto.setId(contact.getId());
		        dto.setEmail_Id(contact.getEmail_Id());
		        dto.setAddress(contact.getAddress());
		        return dto;
		    }

		    private Contact convertToEntity(ContactDto dto) {
		        Contact contact = new Contact();
		        contact.setId(dto.getId());
		        contact.setEmail_Id(dto.getEmail_Id());
		        contact.setAddress(dto.getAddress());
		        return contact;
		    }

	}


