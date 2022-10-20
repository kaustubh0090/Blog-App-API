package com.blog.app.controllers;


import com.blog.app.payloads.CategoryDto;
import com.blog.app.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog/api/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("saveCategory")
    ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {

        CategoryDto category = categoryService.createCategory(categoryDto);


        return new ResponseEntity<>(category, HttpStatus.CREATED);


    }

    @PutMapping("updateCategory/{categoryId}")
    ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("categoryId") Integer categoryId) {

        CategoryDto categoryDto1 = categoryService.updateCategory(categoryDto, categoryId);

        return ResponseEntity.ok(categoryDto1);
    }


    @GetMapping("getCategoryById/{categoryId}")
    ResponseEntity<CategoryDto> getCategoryById(@PathVariable("categoryId") Integer categoryId) {

        CategoryDto categoryById = categoryService.getCategoryById(categoryId);

        return ResponseEntity.ok(categoryById);

    }


    @GetMapping("allCategories")
    ResponseEntity<List<CategoryDto>> allCategories() {

        List<CategoryDto> allCategories = categoryService.getAllCategories();

        return ResponseEntity.ok(allCategories);

    }

    @DeleteMapping("deleteCategory/{categoryId}")
    ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Integer categoryId) {

        categoryService.deleteCategoryById(categoryId);

        return new ResponseEntity<>(Map.of("message", "category deleted successfully"), HttpStatus.OK);
    }


}
