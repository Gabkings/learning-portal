package com.gabkings.learning_portal.repository;

import com.gabkings.learning_portal.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByTitleIgnoreCaseAndCategoryId(String title, Long categoryId);

    Page<Course> findAllByCategoryId(Long categoryId, Pageable pageable);

    Page<Course> findAllByInstructorId(Long instructorId, Pageable pageable);
}
