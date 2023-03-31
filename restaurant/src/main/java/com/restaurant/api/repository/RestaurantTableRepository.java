package com.restaurant.api.repository;

import com.restaurant.api.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {

    RestaurantTable findOneByTableNumber(Integer tableNumber);
}
