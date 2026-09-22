package com.ga.items.controller;

import com.ga.items.model.Category;
import com.ga.items.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/categories")
    public List<Category> getCategories() {
        System.out.println("Controller called getCategories() ==>");
        return categoryService.getCategories();
    }

    @GetMapping("categories/{id}")
    public Category getcategory(@PathVariable Long id) {
        System.out.println("Controller called getCategory() ==>");
        return categoryService.getCategory(id);
    }

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category) {
        System.out.println("Controller called createCategory() ==>");
        return categoryService.createCategory(category);
    }
}
