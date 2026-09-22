package com.ga.items.service;

import com.ga.items.acception.InformationExistsException;
import com.ga.items.model.Category;
import com.ga.items.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        System.out.println("Service called getCategories() ==>");
        return categoryRepository.findAll();
    }

    public Category getCategory(Long id) {
        System.out.println("Service called getCategory() ==>");
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category createCategory(Category categoryObject) {
        System.out.println("Service called createCategory() ==>");
        Category category = categoryRepository.getByName(categoryObject.getName());

        if (category != null) {
            throw new InformationExistsException("category with name " + category.getName() + " already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }
}
