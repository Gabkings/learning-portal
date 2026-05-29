package com.gabkings.learning_portal.repository;

import com.gabkings.learning_portal.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
