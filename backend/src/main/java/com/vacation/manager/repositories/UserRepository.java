package com.vacation.manager.repositories;

import com.vacation.manager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE (:username IS NULL OR u.username LIKE %:username%) AND (:role IS NULL OR u.role LIKE %:role%) AND (:team IS NULL OR u.team LIKE %:team%)")
    Page<User> findFilteredUsers(@Param("username") String username, @Param("role") String role, @Param("team") String team, Pageable pageable);
}
