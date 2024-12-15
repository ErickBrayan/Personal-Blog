package com.eb2.personalblog.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record ArticleRequestDto(
		@NotEmpty
		@Size(min = 3, max = 255)
		String title,
		@NotEmpty
		@Size(min = 3, max = 600)
		String content
) {

}
