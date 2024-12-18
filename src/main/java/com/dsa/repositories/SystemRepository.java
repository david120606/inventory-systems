package com.dsa.repositories;

import com.dsa.entities.schema.System;
import com.dsa.entities.enums.SystemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface SystemRepository extends JpaRepository<System, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE System s SET s.status = :status WHERE s.id = :id")
    int updateSystemStatus(@Param("id") Long id, @Param("status") SystemStatus status);
}
