package com.onlineCourseManagementSystem.service;

import com.onlineCourseManagementSystem.Dtos.CourseRequestDTO;
import com.onlineCourseManagementSystem.Dtos.CourseResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public interface CourseService {

    CourseResponseDTO createCourse(CourseRequestDTO request, Long instructorId);

    CourseResponseDTO updateCourse(Long courseId, CourseRequestDTO request);

    void deleteCourse(Long courseId);

    Page<CourseResponseDTO> listCourses(int page, int size, String sortBy, String direction);

    CourseResponseDTO getCourseById(Long courseId);

}