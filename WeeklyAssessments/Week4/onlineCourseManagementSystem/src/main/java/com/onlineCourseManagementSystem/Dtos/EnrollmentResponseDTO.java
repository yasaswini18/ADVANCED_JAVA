package com.onlineCourseManagementSystem.Dtos;

import lombok.*;
import java.time.LocalDateTime;
import com.onlineCourseManagementSystem.entity.EnrollmentStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentResponseDTO {

    private Long id;
    private String courseTitle;
    private String studentName;
    private EnrollmentStatus status;
    private double progressPercentage;
    private LocalDateTime enrollmentDate;

}