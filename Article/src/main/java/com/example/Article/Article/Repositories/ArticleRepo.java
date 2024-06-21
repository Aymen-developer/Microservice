package com.example.Article.Article.Repositories;

import com.example.Article.Article.Entities.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepo extends MongoRepository<Article, Long> {
}
