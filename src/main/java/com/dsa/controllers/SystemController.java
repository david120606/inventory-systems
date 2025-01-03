package com.dsa.controllers;

import com.dsa.entities.dto.CommentInvalid;
import com.dsa.entities.schema.System;
import com.dsa.entities.dto.SystemDTO;
import com.dsa.entities.enums.SystemStatus;
import com.dsa.services.SystemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestParam SystemStatus status) {
        systemService.updateStatus(id, status);
        return ResponseEntity.ok("System status updated successfully");
    }

    @PatchMapping("/system/{id}/validate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> validateSystem(@PathVariable Long id) {
        systemService.validateSystem(id);
        return ResponseEntity.ok("System validated successfully");
    }

    @PatchMapping("/system/{id}/invalidate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> removeValidationSystem(
            @PathVariable Long id,
            @Valid @RequestBody CommentInvalid commentInvalid
    ) {
        systemService.removeValidationSystem(id, commentInvalid.getComment());
        return ResponseEntity.ok("System unvalidated successfully");
    }

    @GetMapping("/system/status/{status}/next")
    public ResponseEntity<Map<String, Object>> getNextByStatus(
            @PathVariable SystemStatus status,
            @RequestParam(required = false) Long lastId,
            @RequestParam(defaultValue = "10") int size
    ) {
        Map<String, Object> response = systemService.nextPageByStatus(status, lastId, size);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/system/status/{status}/previous")
    public ResponseEntity<Map<String, Object>> getPreviousByStatus(
            @PathVariable SystemStatus status,
            @RequestParam Long firstId,
            @RequestParam(defaultValue = "10") int size
    ) {
        Map<String, Object> response = systemService.previousPageByStatus(status, firstId, size);
        return ResponseEntity.ok(response);
    }

}

