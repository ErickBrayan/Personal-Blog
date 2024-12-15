package com.eb2.personalblog.persistense.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate publishDate;

    @Column(length = 600)
    private String content;



    public Article(Long id, String title, LocalDate publishDate, String content) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.content = content;
    }

    public Article() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @PrePersist
    private void PrePersist() {
        this.publishDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", content='" + content + '\'' +
                '}';
    }
}
