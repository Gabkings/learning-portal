package com.gabkings.learning_portal.repository;

import com.gabkings.learning_portal.entity.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    boolean existsByNameIgnoreCaseAndCourseId(String name, Long courseId);

    Page<Lesson> findAllByCourseId(Long courseId, Pageable pageable);
}
