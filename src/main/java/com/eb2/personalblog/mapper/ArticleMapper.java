package com.eb2.personalblog.mapper;

import com.eb2.personalblog.dto.ArticleRequestDto;
import com.eb2.personalblog.dto.ArticleResponseDto;
import com.eb2.personalblog.persistense.entities.Article;

import java.util.List;

public class ArticleMapper {

    public static Article toEntity(ArticleRequestDto articleDto) {
        Article article = new Article();
        article.setTitle(articleDto.title());
        article.setContent(articleDto.content());
        return article;
    }

    public static ArticleResponseDto toDto(Article article) {
        return new ArticleResponseDto(article.getId(), article.getTitle(), article.getContent(), article.getPublishDate());
    }

    public static ArticleRequestDto toDtoRequest(Article article) {
        return new ArticleRequestDto(article.getTitle(), article.getContent());
    }

    public static List<ArticleResponseDto> toDtoList(List<Article> articles) {

        return articles.stream()
                .map(ArticleMapper::toDto)
                .toList();
    }
}
