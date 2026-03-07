package com.onlineCourseManagementSystem.controller;

import com.onlineCourseManagementSystem.Dtos.EnrollmentRequestDTO;
import com.onlineCourseManagementSystem.Dtos.EnrollmentResponseDTO;
import com.onlineCourseManagementSystem.service.EnrollmentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public EnrollmentResponseDTO enroll(@Valid@RequestBody EnrollmentRequestDTO request) {
        return enrollmentService.enrollStudent(request);
    }

    @GetMapping("/student/{studentId}")
    public List<EnrollmentResponseDTO> getStudentEnrollments(@PathVariable Long studentId) {
        return enrollmentService.getStudentEnrollments(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<EnrollmentResponseDTO> getCourseEnrollments(@PathVariable Long courseId) {
        return enrollmentService.getStudentEnrollments(courseId);
    }
}