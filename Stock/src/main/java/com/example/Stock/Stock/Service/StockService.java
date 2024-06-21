package com.example.Stock.Stock.Service;

import com.example.Stock.Stock.Entities.Stock;
import com.example.Stock.Stock.Repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepo stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock updateStock(Long id, Stock updatedStock) {
        Optional<Stock> optionalStock = stockRepository.findById(id);
        if (optionalStock.isPresent()) {
            Stock existingStock = optionalStock.get();
            existingStock.setName(updatedStock.getName());
            existingStock.setDescription(updatedStock.getDescription());
            return stockRepository.save(existingStock);
        } else {
            throw new IllegalArgumentException("Stock not found with id: " + id);
        }
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
