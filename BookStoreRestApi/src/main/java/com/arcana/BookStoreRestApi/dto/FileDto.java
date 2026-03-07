package com.arcana.BookStoreRestApi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
	
	private Long id;
	
	private String fileName;
	
	private String fileType;
	
	private Long fileSize;
	
	private LocalDateTime uploadedAt;
}
