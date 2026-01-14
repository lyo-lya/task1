package com.ehu.javacafe;

import com.ehu.javacafe.configuration.ComponentScanConfiguration;
import com.ehu.javacafe.configuration.DatabaseConfiguration;
import com.ehu.javacafe.configuration.JdbcInfrastructureConfig;
import com.ehu.javacafe.configuration.RepositoryConfiguration;
import com.ehu.javacafe.entity.Beverage;
import com.ehu.javacafe.service.BeverageDiscountService;
import com.ehu.javacafe.service.BeverageSelectorRandom;
import com.ehu.javacafe.service.CoffeeMachineService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainAnnotation {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                DatabaseConfiguration.class,
                JdbcInfrastructureConfig.class,
                RepositoryConfiguration.class,
                ComponentScanConfiguration.class);

        System.out.println("\n--- 1. Prototype BeverageSelector ---");
        List<Beverage> order = ctx.getBean(BeverageSelectorRandom.class).selectBeverage();
        order.forEach(b -> System.out.println("Selected: " + b.getName()));

        System.out.println("\n--- 2. BeverageDiscountService ---");
        double totalDiscount = ctx.getBean(BeverageDiscountService.class)
                .calculateTotalDiscount(0.1);
        System.out.println("Total discount: " + totalDiscount);

        System.out.println("\n--- 3. CoffeeMachineService (initialized after delay) ---");
        Thread.sleep(4000); // задержка
        ctx.getBean(CoffeeMachineService.class).brewCoffee();

        System.out.println("\nClosing application context to trigger @PreDestroy...");
        ctx.close();
    }
}
