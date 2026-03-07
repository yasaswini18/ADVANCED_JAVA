package com.onlineCourseManagementSystem.Dtos;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequestDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Positive
    private double price;

    @NotBlank
    private String duration;

    @NotBlank
    private String level;

}