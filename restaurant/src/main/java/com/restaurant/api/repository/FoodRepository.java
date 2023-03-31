package com.restaurant.api.repository;

import com.restaurant.api.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByCategoryId(Integer categoryId);
}
