package com.onlineCourseManagementSystem.Dtos;

import lombok.*;
import java.time.LocalDateTime;
import com.onlineCourseManagementSystem.entity.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    private Long id;
    private String fullName;
    private String email;
    private Role role;
    private String profilePicture;
    private LocalDateTime createdAt;

}