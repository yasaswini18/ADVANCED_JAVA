package com.arcana.BookStoreRestApi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
@Schema(name="Book DTO")
public class BookDto {
	
	@NotBlank(message="Title should not be blank")
	private String title;
	
	@NotBlank(message="Book should have an author")
	private String author;
	
	@Positive
	@Min(value=100, message = "Minimum price should be 100")
	private double price;
}
