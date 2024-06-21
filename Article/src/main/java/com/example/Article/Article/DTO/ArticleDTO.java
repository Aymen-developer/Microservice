package com.example.Article.Article.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDTO {
    private Long id;
    private String name;
    private String description;
    private Long stockId;

    // Getters and setters
}
