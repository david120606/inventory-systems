package com.dsa.services;

import com.dsa.entities.schema.System;
import com.dsa.entities.enums.SystemStatus;
import com.dsa.exceptions.BusinessException;
import com.dsa.repositories.SystemRepository;
import com.dsa.services.pagination.PaginationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class SystemService extends PaginationService<System> {

    private final SystemRepository systemRepository;

    public SystemService(SystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }

    public System saveSystem(System system) {
        return systemRepository.save(system);
    }

    public void updateStatus(Long id, SystemStatus status) {
        int rowsAffected = systemRepository.updateSystemStatus(id, status);
        if (rowsAffected == 0) {
            throw new IllegalArgumentException("System with ID " + id + " not found");
        }
    }

    public void validateSystem(Long id) {
        int rowsAffected = systemRepository.validateSystem(id);
        if (rowsAffected == 0) {
            throw new BusinessException("System with ID " + id + " not found", NOT_FOUND);
        }
    }

    public void removeValidationSystem(Long id, String comment) {
        int rowsAffected = systemRepository.removeValidationSystem(id, comment);
        if (rowsAffected == 0) {
            throw new BusinessException("System with ID " + id + " not found.", NOT_FOUND);
        }
    }


    public Map<String, Object> nextPageByStatus(SystemStatus status, Long lastId, int size) {
        long totalRecords = systemRepository.countByStatus(status);
        int totalPages = calculateTotalPages(totalRecords, size);

        lastId = (lastId == null) ? 0L : lastId;
        Pageable pageable = PageRequest.of(0, size);
        List<System> systems = systemRepository.findNextPageByStatus(status, lastId, pageable);

        return buildResponse(systems, totalRecords, totalPages, size);
    }

    public Map<String, Object> previousPageByStatus(SystemStatus status, Long firstId, int size) {
        if (firstId == null) {
            throw new IllegalArgumentException("Cursor is required for fetching previous pages.");
        }

        long totalRecords = systemRepository.countByStatus(status);
        int totalPages = calculateTotalPages(totalRecords, size);

        Pageable pageable = PageRequest.of(0, size);
        List<System> systems = systemRepository.findPreviousPageByStatus(status, firstId, pageable);

        Collections.reverse(systems);

        return buildResponse(systems, totalRecords, totalPages, size);
    }

}