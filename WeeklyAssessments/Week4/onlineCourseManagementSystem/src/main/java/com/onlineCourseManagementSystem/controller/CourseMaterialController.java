package com.onlineCourseManagementSystem.controller;

import com.onlineCourseManagementSystem.Dtos.MaterialUploadDTO;
import com.onlineCourseManagementSystem.Dtos.MaterialResponseDTO;
import com.onlineCourseManagementSystem.service.CourseMaterialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
@RequiredArgsConstructor
public class CourseMaterialController {

    private final CourseMaterialService materialService;

    @PostMapping("/upload")
    public MaterialResponseDTO uploadMaterial(@ModelAttribute @Valid MaterialUploadDTO request) {
        return materialService.uploadMaterial(request);
    }

    @GetMapping("/{id}/download")
    public MaterialResponseDTO downloadMaterial(@PathVariable Long id) {
        return materialService.downloadMaterial(id);
    }

    @GetMapping("/course/{courseId}")
    public List<MaterialResponseDTO> getCourseMaterials(@PathVariable Long courseId) {
        return materialService.listCourseMaterials(courseId);
    }
}