package com.example.Stock.Stock.Controller;

import com.example.Stock.Stock.Entities.Stock;
import com.example.Stock.Stock.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Optional<Stock> stock = stockService.getStockById(id);
        return stock.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        Stock createdStock = stockService.createStock(stock);
        return new ResponseEntity<>(createdStock, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock updatedStock) {
        Stock updated = stockService.updateStock(id, updatedStock);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
