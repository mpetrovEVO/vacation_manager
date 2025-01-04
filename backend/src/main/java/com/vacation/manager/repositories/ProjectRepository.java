package com.vacation.manager.repositories;

import com.vacation.manager.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p WHERE (:name IS NULL OR p.name LIKE %:name%) AND (:description IS NULL OR p.description LIKE %:description%)")
    Page<Project> findFilteredProjects(@Param("name") String name, @Param("description") String description, Pageable pageable);
}
