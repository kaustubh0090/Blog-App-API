package com.blog.app.services;

import com.blog.app.payloads.CategoryDto;
import com.blog.app.payloads.UserDto;

import java.util.List;

public interface CategoryService {

    public CategoryDto createCategory(CategoryDto categoryDto);

    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    public CategoryDto getCategoryById(Integer categoryId);

    public List<CategoryDto> getAllCategories();

    public void deleteCategoryById(Integer categoryId);


}
