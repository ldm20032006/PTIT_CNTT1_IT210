package com.restaurant.bai4.service;

import com.restaurant.bai4.model.DishB4;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdminDishLayoutService {
    private final Map<Integer, DishB4> dishStore = new LinkedHashMap<>();

    public AdminDishLayoutService() {
        dishStore.put(1, new DishB4(1, "Pho Bo", 50000.0, "Nuoc dung trong, thit bo mem."));
        dishStore.put(2, new DishB4(2, "Com Tam", 45000.0, "Com tam suon bi cha, an kem nuoc mam chua ngot."));
        dishStore.put(3, new DishB4(3, "Bun Cha", 55000.0, "Cha nuong than hoa, an kem bun tuoi."));
    }

    public List<DishB4> findAll() {
        return new ArrayList<>(dishStore.values());
    }

    public Optional<DishB4> findById(Integer id) {
        return Optional.ofNullable(dishStore.get(id));
    }
}
