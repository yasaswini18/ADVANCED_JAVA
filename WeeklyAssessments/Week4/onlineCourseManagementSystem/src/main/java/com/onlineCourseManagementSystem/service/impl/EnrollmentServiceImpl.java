package com.onlineCourseManagementSystem.service.impl;

import com.onlineCourseManagementSystem.Dtos.EnrollmentRequestDTO;
import com.onlineCourseManagementSystem.Dtos.EnrollmentResponseDTO;
import com.onlineCourseManagementSystem.entity.Course;
import com.onlineCourseManagementSystem.entity.Enrollment;
import com.onlineCourseManagementSystem.entity.EnrollmentStatus;
import com.onlineCourseManagementSystem.entity.User;
import com.onlineCourseManagementSystem.repository.CourseRepository;
import com.onlineCourseManagementSystem.repository.EnrollmentRepository;
import com.onlineCourseManagementSystem.repository.UserRepository;
import com.onlineCourseManagementSystem.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Override
    public EnrollmentResponseDTO enrollStudent(EnrollmentRequestDTO request) {

        User student = userRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .course(course)
                .status(EnrollmentStatus.ACTIVE)
                .progressPercentage(0)
                .build();

        Enrollment saved = enrollmentRepository.save(enrollment);

        return EnrollmentResponseDTO.builder()
                .id(saved.getId())
                .courseTitle(course.getTitle())
                .studentName(student.getFullName())
                .status(saved.getStatus())
                .progressPercentage(saved.getProgressPercentage())
                .enrollmentDate(saved.getEnrollmentDate())
                .build();
    }

    @Override
    public List<EnrollmentResponseDTO> getStudentEnrollments(Long studentId) {

        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(studentId);

        return enrollments.stream().map(e ->
                EnrollmentResponseDTO.builder()
                        .id(e.getId())
                        .courseTitle(e.getCourse().getTitle())
                        .studentName(e.getStudent().getFullName())
                        .status(e.getStatus())
                        .progressPercentage(e.getProgressPercentage())
                        .enrollmentDate(e.getEnrollmentDate())
                        .build()
        ).toList();
    }

    @Override
    public EnrollmentResponseDTO updateProgress(Long enrollmentId, double progress) {

        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        enrollment.setProgressPercentage(progress);

        Enrollment updated = enrollmentRepository.save(enrollment);

        return EnrollmentResponseDTO.builder()
                .id(updated.getId())
                .courseTitle(updated.getCourse().getTitle())
                .studentName(updated.getStudent().getFullName())
                .status(updated.getStatus())
                .progressPercentage(updated.getProgressPercentage())
                .enrollmentDate(updated.getEnrollmentDate())
                .build();
    }
}