package com.eb2.personalblog.service;

import com.eb2.personalblog.dto.ArticleRequestDto;
import com.eb2.personalblog.dto.ArticleResponseDto;
import com.eb2.personalblog.persistense.entities.Article;

import java.util.List;

public interface ArticleService {

    List<ArticleResponseDto> findAll();
    Article update(long id, ArticleRequestDto article);
    Article save(ArticleRequestDto article);
    void deleteById(long id);

    Article findById(Long articleId);
}
