package com.arcana.BookStoreRestApi.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Files")
public class FileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String fileName;
	private String fileType;
	private Long fileSize;
	
	@Lob
	@Column(name = "file_data", columnDefinition = "LONGBLOB")
	private byte[] fileData;           //Actual file content as byte array
	
	private LocalDateTime uploadedAt;
	
	@PrePersist
	public void prePersist() {
		uploadedAt = LocalDateTime.now();
	}
	
	
}
