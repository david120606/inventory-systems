package com.dsa.repositories;

import com.dsa.entities.schema.System;
import com.dsa.entities.enums.SystemStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

import java.util.List;


public interface SystemRepository extends JpaRepository<System, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE System s SET s.status = :status WHERE s.id = :id")
    int updateSystemStatus(@Param("id") Long id, @Param("status") SystemStatus status);

    @Transactional
    @Modifying
    @Query("UPDATE System s SET s.validated = true WHERE s.id = :id")
    int validateSystem(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE System s SET s.validated = false, s.validationComment = :comment WHERE s.id = :id")
    int removeValidationSystem(@Param("id") Long id, @Param("comment") String comment);


    @Query("SELECT s FROM System s WHERE s.status = :status AND s.id > :lastId ORDER BY s.id ASC")
    List<System> findNextPageByStatus(
            @Param("status") SystemStatus status,
            @Param("lastId") Long lastId,
            Pageable pageable
    );

    @Query("SELECT s FROM System s WHERE s.status = :status AND s.id < :firstId ORDER BY s.id DESC")
    List<System> findPreviousPageByStatus(
            @Param("status") SystemStatus status,
            @Param("firstId") Long firstId,
            Pageable pageable
    );


    @Query("SELECT COUNT(s) FROM System s WHERE s.status = :status")
    long countByStatus(@Param("status") SystemStatus status);



}
