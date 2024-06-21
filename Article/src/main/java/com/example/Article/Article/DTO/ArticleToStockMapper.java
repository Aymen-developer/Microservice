package com.example.Article.Article.DTO;

public record ArticleToStockMapper() {

        public static StockDTO map(ArticleDTO article) {
            Objects.requireNonNull(article, "Article cannot be null");

            return StockDTO.builder()
                    .id(article.stockId())
                    .name(article.name())
                    .quantity(0) // Set default quantity or fetch from another source
                    .build();

    }
}
