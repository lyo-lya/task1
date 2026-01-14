package com.ehu.javacafe.service;

import com.ehu.javacafe.entity.Beverage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
public class CoffeeMachineService {
    private static final Logger logger = LoggerFactory.getLogger(CoffeeMachineService.class);

    private final BeverageSelectorRandom beverageSelector;

    public CoffeeMachineService(BeverageSelectorRandom beverageSelector) {
        logger.info("CoffeeMachineService CONSTRUCTOR called");
        this.beverageSelector = beverageSelector;
    }

    public void brewCoffee() {
        logger.info("CoffeeMachineService started brewing");

        List<Beverage> order = beverageSelector.selectBeverage();

        for (Beverage beverage : order) {
            System.out.println("Brewing: " + beverage.getName());
        }

        logger.info("Coffee is ready");
    }
}
