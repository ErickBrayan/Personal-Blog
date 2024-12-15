package com.eb2.personalblog.persistense.repository;

import com.eb2.personalblog.persistense.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
