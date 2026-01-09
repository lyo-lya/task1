package com.ehu.javacafe.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class CoffeeMachineService {
    public CoffeeMachineService() {
        System.out.println("Coffee machine is warming up...");
    }

    public void brewCoffee() {
        System.out.println("Brewing a fresh cup of coffee...");
    }
}
