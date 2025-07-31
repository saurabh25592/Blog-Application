package com.traning.AcademicTraning.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
	
	private int id;
    
	
	@NotBlank(message = "emaill is mendatory.....")
	@Size(min=9, message="should be 9 chracter....." )
	private String email_Id;
	
	@NotBlank(message = "Address is mandatory..........")
	private String address;

	
}
