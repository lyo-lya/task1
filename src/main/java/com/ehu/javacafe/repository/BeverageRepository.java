package com.ehu.javacafe.repository;

import com.ehu.javacafe.entity.Beverage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeverageRepository {
    List<Beverage> getAllBeverages();

    boolean addBeverage(Beverage beverage);

    Beverage deleteBeverage(long id);

    Beverage getBeverageById(long id);

    long getBeverageCount();
}
