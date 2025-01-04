package com.vacation.manager.repositories;

import com.vacation.manager.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("SELECT t FROM Team t WHERE (:name IS NULL OR t.name LIKE %:name%) AND (:project IS NULL OR t.project LIKE %:project%)")
    Page<Team> findFilteredTeams(@Param("name") String name, @Param("project") String project, Pageable pageable);
}
