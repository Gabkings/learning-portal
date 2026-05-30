package com.gabkings.learning_portal.repository;

import com.gabkings.learning_portal.entity.Enrollment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Page<Enrollment> findAllByCourseId(Long courseId, Pageable pageable);
    Page<Enrollment> findAllByUserId(Long userId, Pageable pageable);
    List<Enrollment> findAllByEnrollmentDateBefore(LocalDateTime dateTime);
}
