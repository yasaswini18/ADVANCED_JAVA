package com.onlineCourseManagementSystem.service.impl;

import com.onlineCourseManagementSystem.Dtos.MaterialUploadDTO;
import com.onlineCourseManagementSystem.Dtos.MaterialResponseDTO;
import com.onlineCourseManagementSystem.entity.Course;
import com.onlineCourseManagementSystem.entity.CourseMaterial;
import com.onlineCourseManagementSystem.repository.CourseMaterialRepository;
import com.onlineCourseManagementSystem.repository.CourseRepository;
import com.onlineCourseManagementSystem.service.CourseMaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseMaterialServiceImpl implements CourseMaterialService {

    private final CourseMaterialRepository materialRepository;
    private final CourseRepository courseRepository;

    @Override
    public MaterialResponseDTO uploadMaterial(MaterialUploadDTO request) {

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        CourseMaterial material = CourseMaterial.builder()
                .title(request.getTitle())
                .fileName(request.getFile().getOriginalFilename())
                .fileType(request.getFile().getContentType())
                .fileUrl("/uploads/" + request.getFile().getOriginalFilename())
                .course(course)
                .build();

        CourseMaterial saved = materialRepository.save(material);

        return MaterialResponseDTO.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .fileName(saved.getFileName())
                .fileType(saved.getFileType())
                .fileUrl(saved.getFileUrl())
                .uploadDate(saved.getUploadDate())
                .build();
    }

    @Override
    public MaterialResponseDTO downloadMaterial(Long materialId) {

        CourseMaterial material = materialRepository.findById(materialId)
                .orElseThrow(() -> new RuntimeException("Material not found"));

        return MaterialResponseDTO.builder()
                .id(material.getId())
                .title(material.getTitle())
                .fileName(material.getFileName())
                .fileType(material.getFileType())
                .fileUrl(material.getFileUrl())
                .uploadDate(material.getUploadDate())
                .build();
    }

    @Override
    public List<MaterialResponseDTO> listCourseMaterials(Long courseId) {

        List<CourseMaterial> materials = materialRepository.findByCourseId(courseId);

        return materials.stream().map(m ->
                MaterialResponseDTO.builder()
                        .id(m.getId())
                        .title(m.getTitle())
                        .fileName(m.getFileName())
                        .fileType(m.getFileType())
                        .fileUrl(m.getFileUrl())
                        .uploadDate(m.getUploadDate())
                        .build()
        ).toList();
    }
}