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

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category ){
        System.out.println("Controller called updateCategory() ==>");
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/categories/{id}")
    public Category deleteCategory(@PathVariable Long id){
        System.out.println("Controller called deleteCategory() ==>");
        return categoryService.deleteCategory(id);
    }

}
