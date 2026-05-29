package com.gabkings.learning_portal.repository;

import com.gabkings.learning_portal.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
