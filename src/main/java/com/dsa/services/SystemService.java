package com.dsa.services;

import com.dsa.entities.schema.System;
import com.dsa.entities.enums.SystemStatus;
import com.dsa.exceptions.BusinessException;
import com.dsa.repositories.SystemRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.dsa.config.LoggerApp.info;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

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
            throw new BusinessException("System with ID " + id + " not found", NOT_FOUND);
        }
    }

    public void removeValidationSystem(Long id, String comment) {
        int rowsAffected = systemRepository.removeValidationSystem(id, comment);
        if (rowsAffected == 0) {
            throw new BusinessException("System with ID " + id + " not found.", NOT_FOUND);
        }
    }


}