package com.restaurant.bai3.service;

import com.restaurant.bai3.model.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdminDishService {
    private final Map<Integer, Dish> dishStore = new LinkedHashMap<>();

    public AdminDishService() {
        dishStore.put(1, new Dish(1, "Pho Bo", 50000.0));
        dishStore.put(2, new Dish(2, "Com Tam", 45000.0));
        dishStore.put(3, new Dish(3, "Bun Cha", 55000.0));
    }

    public List<Dish> getAllDishes() {
        return new ArrayList<>(dishStore.values());
    }

    public Optional<Dish> findById(Integer id) {
        return Optional.ofNullable(dishStore.get(id));
    }

    public void updateDish(Integer id, Dish updatedDish) {
        Dish existingDish = dishStore.get(id);
        if (existingDish == null) {
            return;
        }
        existingDish.setName(updatedDish.getName());
        existingDish.setPrice(updatedDish.getPrice());
    }
}
