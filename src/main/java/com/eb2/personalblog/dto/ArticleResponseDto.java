package com.eb2.personalblog.dto;

import java.time.LocalDate;

public record ArticleResponseDto(
        Long id,
        String title,
        String content,
        LocalDate publishedDate
) {
}
