package com.gabkings.learning_portal.repository;

import com.gabkings.learning_portal.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
