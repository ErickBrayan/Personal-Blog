package com.eb2.personalblog.service.impl;

import com.eb2.personalblog.dto.ArticleRequestDto;
import com.eb2.personalblog.dto.ArticleResponseDto;
import com.eb2.personalblog.mapper.ArticleMapper;
import com.eb2.personalblog.persistense.entities.Article;
import com.eb2.personalblog.persistense.repository.ArticleRepository;
import com.eb2.personalblog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {


    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleResponseDto> findAll() {
        return ArticleMapper.toDtoList(articleRepository.findAll());
    }

    @Override
    public Article update(long id, ArticleRequestDto articleRequestDto) {

        Article article =  articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));

        System.out.println(article);
        article.setTitle(articleRequestDto.title());
        article.setContent(articleRequestDto.content());

        return articleRepository.save(article);
    }

    @Override
    public Article save(ArticleRequestDto article) {
        return articleRepository.save(ArticleMapper.toEntity(article));
    }

    @Override
    public Article findById(Long articleId) {
        return articleRepository.findById(articleId).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        articleRepository.deleteById(id);
    }
}
