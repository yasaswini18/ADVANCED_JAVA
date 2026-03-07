package com.onlineCourseManagementSystem.Dtos;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialResponseDTO {

    private Long id;
    private String title;
    private String fileName;
    private String fileType;
    private String fileUrl;
    private LocalDateTime uploadDate;

}