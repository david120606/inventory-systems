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

}