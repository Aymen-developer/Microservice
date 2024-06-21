package com.example.Article.Article.Controllers;

import com.example.Article.Article.Entities.Article;
import com.example.Article.Article.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") long id) {
        return articleService.getArticleById(id)
                .map(article -> ResponseEntity.ok().body(article))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article createdArticle = articleService.createOrUpdateArticle(article);
        return new ResponseEntity<>(createdArticle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") long id, @RequestBody Article article) {
        article.setId(id);
        Article updatedArticle = articleService.createOrUpdateArticle(article);
        return ResponseEntity.ok().body(updatedArticle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("id") long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.ok().build();
    }
}
