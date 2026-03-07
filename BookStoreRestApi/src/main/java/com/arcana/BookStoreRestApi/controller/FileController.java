package com.arcana.BookStoreRestApi.controller;

import java.io.IOException;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.arcana.BookStoreRestApi.dto.FileDto;
import com.arcana.BookStoreRestApi.entity.FileEntity;
import com.arcana.BookStoreRestApi.service.FileService;

import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/files")
@RequiredArgsConstructor
public class FileController {
	
	private final FileService service;
	
	@PostMapping("/upload")
	public ResponseEntity<FileDto> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
		
		FileDto uploadedFile = service.uploadFile(file);
		
		return ResponseEntity.ok(uploadedFile);
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long id){
		
		FileEntity fileEntity = service.downloadFile(id);
		ByteArrayResource resource = new ByteArrayResource(fileEntity.getFileData());
		
		return ResponseEntity.ok()
		        .contentType(MediaType.parseMediaType(fileEntity.getFileType()))
		        .header(HttpHeaders.CONTENT_DISPOSITION,
		                "attachment; filename=\"" + fileEntity.getFileName() + "\"")
		        .contentLength(fileEntity.getFileSize())
		        .body(resource);
	}
}
