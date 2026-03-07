package com.onlineCourseManagementSystem.Dtos;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentRequestDTO {

    @NotNull
    private Long courseId;

    @NotNull
    private Long studentId;

}