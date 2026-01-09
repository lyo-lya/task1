package com.ehu.javacafe.service;

import com.ehu.javacafe.entity.Beverage;
import com.ehu.javacafe.repository.BeverageRepository;
import org.springframework.stereotype.Service;

@Service
public class BeverageDiscountService {
    private final BeverageRepository beverageRepository;

    public BeverageDiscountService(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    public double calculateTotalDiscount(double discountRate) {
        return beverageRepository.getAllBeverages()
                .stream()
                .mapToDouble(Beverage::getPrice)
                .map(price -> price * discountRate)
                .sum();
    }
}
