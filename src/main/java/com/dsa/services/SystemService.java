package com.dsa.services;

import com.dsa.entities.dto.System;
import com.dsa.entities.dto.enums.SystemStatus;
import com.dsa.repositories.SystemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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