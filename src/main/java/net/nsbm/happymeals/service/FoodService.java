package net.nsbm.happymeals.service;

import java.util.List;

import net.nsbm.happymeals.model.Food;

public interface FoodService
{
    List<Food> findAll();

    void save(Food food);

    Food findById(int id);

    Food findByTitle(String title);

    List<Food> findByCategory(String category);

    void deleteById(int id);

    List<Food> searchByTitle(String title);
}
