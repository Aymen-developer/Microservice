package com.example.Stock.Stock.Repository;

import com.example.Stock.Stock.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepo extends JpaRepository<Stock, Long> {
}
