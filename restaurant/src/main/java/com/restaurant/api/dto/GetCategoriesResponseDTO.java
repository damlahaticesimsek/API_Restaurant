package com.restaurant.api.dto;

import com.restaurant.api.entity.Category;

public class GetCategoriesResponseDTO {
    private Long id;
    private String categoryName;

    public void importFrom(Category category){
        this.setId(category.getId());
        this.setCategoryName(category.getCategoryName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
