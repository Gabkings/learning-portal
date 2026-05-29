package com.gabkings.learning_portal.repository;

import com.gabkings.learning_portal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
