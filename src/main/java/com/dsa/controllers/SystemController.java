package com.dsa.controllers;

import com.dsa.entities.schema.System;
import com.dsa.entities.dto.SystemDTO;
import com.dsa.entities.enums.SystemStatus;
import com.dsa.services.SystemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
public class SystemController {

    private final SystemService systemService;

    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    @PostMapping("/system")
    @Operation(summary = "Crea un sistema", description = "Crea un nuevo sistema en el inventario")
    @ApiResponse(responseCode = "200", description = "Sistema creado exitosamente")
    public System createSystem(@Valid @RequestBody SystemDTO systemDTO) {
        System system = systemDTO.toEntity();
        return systemService.saveSystem(system);
    }

    @PatchMapping("/system/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestParam SystemStatus status) {
        systemService.updateStatus(id, status);
        return ResponseEntity.ok("System status updated successfully");
    }

    @PatchMapping("/system/{id}/validate")
    public ResponseEntity<String> validateSystem(@PathVariable Long id) {
        systemService.validateSystem(id);
        return ResponseEntity.ok("System validated successfully");
    }
    @PatchMapping("/system/{id}/invalidate")
    public ResponseEntity<String> removeValidationSystem(
            @PathVariable Long id,
            @RequestBody Map<String, String> requestBody
    ) {
        String comment = requestBody.get("comment");
        systemService.removeValidationSystem(id, comment);
        return ResponseEntity.ok("System unvalidated successfully");
    }

}

