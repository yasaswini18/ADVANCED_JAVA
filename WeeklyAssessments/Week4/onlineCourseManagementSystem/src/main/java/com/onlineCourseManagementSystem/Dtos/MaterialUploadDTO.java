package com.onlineCourseManagementSystem.Dtos;

import lombok.*;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialUploadDTO {

    @NotBlank
    private String title;

    @NotNull
    private Long courseId;

    @NotNull
    private MultipartFile file;

}