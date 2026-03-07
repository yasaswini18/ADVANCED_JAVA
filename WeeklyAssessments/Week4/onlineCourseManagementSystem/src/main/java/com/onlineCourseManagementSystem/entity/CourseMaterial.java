package com.onlineCourseManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "course_materials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String fileName;

    private String fileType;

    private String fileUrl;

    private LocalDateTime uploadDate;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @PrePersist
    public void onUpload() {
        uploadDate = LocalDateTime.now();
    }
}