package com.onlineCourseManagementSystem.service.impl;

import com.onlineCourseManagementSystem.Dtos.CourseRequestDTO;
import com.onlineCourseManagementSystem.Dtos.CourseResponseDTO;
import com.onlineCourseManagementSystem.entity.Course;
import com.onlineCourseManagementSystem.repository.CourseRepository;
import com.onlineCourseManagementSystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO request, Long instructorId) {

        Course course = Course.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .duration(request.getDuration())
                .level(request.getLevel())
                .build();

        Course savedCourse = courseRepository.save(course);

        return CourseResponseDTO.builder()
                .id(savedCourse.getId())
                .title(savedCourse.getTitle())
                .description(savedCourse.getDescription())
                .price(savedCourse.getPrice())
                .duration(savedCourse.getDuration())
                .level(savedCourse.getLevel())
                .createdAt(savedCourse.getCreatedAt())
                .build();
    }

    @Override
    public CourseResponseDTO updateCourse(Long courseId, CourseRequestDTO request) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setPrice(request.getPrice());
        course.setDuration(request.getDuration());
        course.setLevel(request.getLevel());

        Course updatedCourse = courseRepository.save(course);

        return CourseResponseDTO.builder()
                .id(updatedCourse.getId())
                .title(updatedCourse.getTitle())
                .description(updatedCourse.getDescription())
                .price(updatedCourse.getPrice())
                .duration(updatedCourse.getDuration())
                .level(updatedCourse.getLevel())
                .createdAt(updatedCourse.getCreatedAt())
                .build();
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Page<CourseResponseDTO> listCourses(int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Course> courses = courseRepository.findAll(pageable);

        return courses.map(course ->
                CourseResponseDTO.builder()
                        .id(course.getId())
                        .title(course.getTitle())
                        .description(course.getDescription())
                        .price(course.getPrice())
                        .duration(course.getDuration())
                        .level(course.getLevel())
                        .instructorName(course.getInstructor() != null ? course.getInstructor().getFullName() : null)
                        .createdAt(course.getCreatedAt())
                        .build()
        );
    }

    @Override
    public CourseResponseDTO getCourseById(Long courseId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return CourseResponseDTO.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .price(course.getPrice())
                .duration(course.getDuration())
                .level(course.getLevel())
                .instructorName(course.getInstructor() != null ? course.getInstructor().getFullName() : null)
                .createdAt(course.getCreatedAt())
                .build();
    }
}