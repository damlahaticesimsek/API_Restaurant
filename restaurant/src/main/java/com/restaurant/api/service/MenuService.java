package com.restaurant.api.service;

import com.restaurant.api.dto.GetCategoriesResponseDTO;
import com.restaurant.api.dto.GetMenuResponseDTO;
import com.restaurant.api.entity.Category;
import com.restaurant.api.entity.Food;
import com.restaurant.api.repository.CategoryRepository;
import com.restaurant.api.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Service
public class MenuService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<GetMenuResponseDTO> getMenu() {
        corsConfigurationSource();
        List<GetMenuResponseDTO> responseDTOS = new ArrayList<>();
        List<Food> menu = foodRepository.findAll();

        for (Food food:menu){
            GetMenuResponseDTO responseDTO = new GetMenuResponseDTO();
            responseDTO.importFrom(food);
            responseDTOS.add(responseDTO);
        }

        return responseDTOS;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(List.of("*"));
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(List.of("*"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    public List<GetMenuResponseDTO> getMenuByCategory(Integer categoryId) {

        List<GetMenuResponseDTO> responseDTOS = new ArrayList<>();
        List<Food> menu = foodRepository.findAllByCategoryId(categoryId);

        for (Food food:menu){
            GetMenuResponseDTO responseDTO = new GetMenuResponseDTO();
            responseDTO.importFrom(food);
            responseDTOS.add(responseDTO);
        }

        return responseDTOS;
    }

    public List<GetCategoriesResponseDTO> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<GetCategoriesResponseDTO> responseDTOS = new ArrayList<>();

        for (Category category: categories){
            GetCategoriesResponseDTO responseDTO = new GetCategoriesResponseDTO();
            responseDTO.importFrom(category);
            responseDTOS.add(responseDTO);
        }
        return responseDTOS;
    }
}
