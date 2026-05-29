package com.gabkings.learning_portal.repository;

import com.gabkings.learning_portal.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
