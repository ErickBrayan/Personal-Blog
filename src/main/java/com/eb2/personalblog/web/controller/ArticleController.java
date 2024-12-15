package com.eb2.personalblog.web.controller;

import com.eb2.personalblog.dto.ArticleRequestDto;
import com.eb2.personalblog.dto.ArticleResponseDto;
import com.eb2.personalblog.mapper.ArticleMapper;
import com.eb2.personalblog.persistense.entities.Article;
import com.eb2.personalblog.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin(Model model) {
        List<ArticleResponseDto> list = articleService.findAll();
        model.addAttribute("articles", list);
        return "admin/admin";
    }

    @GetMapping("/")
    public String redirect() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<ArticleResponseDto> list = articleService.findAll();
        model.addAttribute("articles", list);
        return "guest/home";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/new")
    public String showArticle(@ModelAttribute(name = "article")ArticleRequestDto articleRequestDto) {
        return "admin/newArticle";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/new")
    public String newArticle(@Valid @ModelAttribute(name = "article")ArticleRequestDto articleRequestDto,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/newArticle";
        }
        articleService.save(articleRequestDto);
        model.addAttribute("msg", "Article added successfully");
        return "redirect:/admin";
    }


    @GetMapping("/article/{articleId}")
    public String detail(@PathVariable Long articleId, Model model) {
        Article article = articleService.findById(articleId);
        model.addAttribute("detail", article);
        return "shared/detail";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit/{articleId}")
    public String edit(@PathVariable Long articleId, Model model) {
        Article article = articleService.findById(articleId);
        model.addAttribute("article", ArticleMapper.toDto(article));
        return "admin/newArticle";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/edit/{articleId}")
    public String edit(@PathVariable Long articleId, Model model,
                       @Valid @ModelAttribute(name = "article")ArticleRequestDto articleRequestDto,
                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) return "admin/newArticle";

        articleService.update(articleId, articleRequestDto);
        model.addAttribute("msgEdited", "Article edited successfully");
        return "redirect:/admin";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete/{articleId}")
    public String delete(@PathVariable Long articleId) {

        articleService.deleteById(articleId);

        return "redirect:/admin";
    }



}
