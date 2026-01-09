package com.ehu.javacafe.service;

import com.ehu.javacafe.entity.Beverage;
import com.ehu.javacafe.repository.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Scope("prototype")
public class BeverageSelectorRandom implements BeverageSelector {
    private final BeverageRepository beverageRepository;
    private final Random random = new Random();

    public BeverageSelectorRandom(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    @Override
    public List<Beverage> selectBeverage() {
        long count = beverageRepository.getBeverageCount();
        int amountOfBeverages = 1 + random.nextInt(3);

        List<Beverage> order = new ArrayList<>();

        for (int i = 0; i < amountOfBeverages; i++) {
            long randomId = 1 + random.nextInt((int) count);
            Beverage beverage = beverageRepository.getBeverageById(randomId);
            if (beverage != null) {
                order.add(beverage);
            }
        }

        return order;
    }
}
