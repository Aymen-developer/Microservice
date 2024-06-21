package com.example.Article.Article.Services;

import com.example.Article.Article.Entities.Article;
import com.example.Article.Article.Repositories.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ArticleService {

    @Autowired
    private ArticleRepo articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(long id) {
        return articleRepository.findById(id);
    }

    public Article createOrUpdateArticle(Article article) {
        return articleRepository.save(article);
    }

    public void deleteArticle(long id) {
        articleRepository.deleteById(id);
    }

}
