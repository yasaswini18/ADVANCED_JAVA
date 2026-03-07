package com.onlineCourseManagementSystem.service;

import com.onlineCourseManagementSystem.Dtos.EnrollmentRequestDTO;
import com.onlineCourseManagementSystem.Dtos.EnrollmentResponseDTO;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface EnrollmentService {

    EnrollmentResponseDTO enrollStudent(EnrollmentRequestDTO request);

    List<EnrollmentResponseDTO> getStudentEnrollments(Long studentId);

    EnrollmentResponseDTO updateProgress(Long enrollmentId, double progress);

}