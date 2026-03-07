package com.onlineCourseManagementSystem.Dtos;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponseDTO {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String duration;
    private String level;
    private String instructorName;
    private LocalDateTime createdAt;

}