package com.dsa.services;

import com.dsa.entities.schema.System;
import com.dsa.entities.enums.SystemStatus;
import com.dsa.repositories.SystemRepository;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

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
            throw new IllegalArgumentException("System with ID " + id + " not found");
        }
    }

    public void removeValidationSystem(Long id, String comment) {
        if (comment == null || comment.trim().isEmpty()) {
            throw new IllegalArgumentException("A validation comment is required to remove validation a system.");
        }
        int rowsAffected = systemRepository.removeValidationSystem(id, comment);
        if (rowsAffected == 0) {
            throw new IllegalArgumentException("System with ID " + id + " not found.");
        }
    }

}