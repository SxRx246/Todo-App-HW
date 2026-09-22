package com.ga.items.repository;

import com.ga.items.model.Category;
import com.ga.items.service.CategoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getByName(String categoryName);
}
