package com.vacation.manager.repositories;

import com.vacation.manager.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE (:name IS NULL OR r.name LIKE %:name%)")
    Page<Role> findFilteredRoles(@Param("name") String name, Pageable pageable);
}
