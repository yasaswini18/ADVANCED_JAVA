package com.onlineCourseManagementSystem.controller;

import com.onlineCourseManagementSystem.Dtos.CourseRequestDTO;
import com.onlineCourseManagementSystem.Dtos.CourseResponseDTO;
import com.onlineCourseManagementSystem.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public CourseResponseDTO createCourse(@Valid @RequestBody CourseRequestDTO request,
                                          @RequestParam Long instructorId) {
        return courseService.createCourse(request, instructorId);
    }

    @PutMapping("/{id}")
    public CourseResponseDTO updateCourse(@PathVariable Long id,
                                          @Valid @RequestBody CourseRequestDTO request) {
        return courseService.updateCourse(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }


    @GetMapping("/{id}")
    public CourseResponseDTO getCourse(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }
    @GetMapping
    public Page<CourseResponseDTO> getCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "title") String sort,
            @RequestParam(defaultValue = "asc") String direction) {

        return courseService.listCourses(page, size, sort, direction);
    }
}