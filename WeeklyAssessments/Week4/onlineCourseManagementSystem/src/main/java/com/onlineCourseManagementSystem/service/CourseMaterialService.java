package com.onlineCourseManagementSystem.service;

import com.onlineCourseManagementSystem.Dtos.MaterialUploadDTO;
import com.onlineCourseManagementSystem.Dtos.MaterialResponseDTO;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CourseMaterialService {

    MaterialResponseDTO uploadMaterial(MaterialUploadDTO request);

    MaterialResponseDTO downloadMaterial(Long materialId);

    List<MaterialResponseDTO> listCourseMaterials(Long courseId);

}