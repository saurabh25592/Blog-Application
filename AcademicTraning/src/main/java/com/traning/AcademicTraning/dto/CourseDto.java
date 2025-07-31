package com.traning.AcademicTraning.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, message = "Title must be at least 3 characters")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;
}