package com.vacation.manager.repositories;

import com.vacation.manager.models.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
    @Query("SELECT l FROM Leave l WHERE (:applicant IS NULL OR l.applicant LIKE %:applicant%) AND (:approved IS NULL OR l.approved = :approved)")
    Page<Leave> findFilteredLeaves(@Param("applicant") String applicant, @Param("approved") Boolean approved, Pageable pageable);
}
