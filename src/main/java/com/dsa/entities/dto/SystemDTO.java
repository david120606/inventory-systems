package com.dsa.entities.dto;

import com.dsa.entities.dto.enums.ArchitectureType;
import com.dsa.entities.dto.enums.SystemStatus;

import javax.validation.constraints.*;
import java.util.List;

public class SystemDTO {
    @NotNull(message = "ID cannot be null")
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    @NotBlank(message = "Technical lead is required")
    private String technicalLead;

    @NotBlank(message = "Functional lead is required")
    private String functionalLead;

    @NotEmpty(message = "At least one environment is required")
    private List<@NotBlank(message = "Environment name cannot be blank") String> environments;

    @NotBlank(message = "Database type is required")
    private String database;

    @NotNull(message = "Architecture type is required")
    private ArchitectureType architectureType;

    @NotBlank(message = "Programming language is required")
    private String programmingLanguage;

    @NotBlank(message = "Version is required")
    @Pattern(regexp = "\\d+\\.\\d+(\\.\\d+)?", message = "Version must follow the pattern x.y or x.y.z")
    private String version;

    @NotBlank(message = "Status is required")
    private SystemStatus status;

    @NotBlank(message = "Repository URL is required")
    @Pattern(regexp = "^(http|https)://.*", message = "Repository URL must be a valid URL")
    private String repositoryUrl;

    @NotBlank(message = "Hosting type is required")
    private String hosting;

    @NotBlank(message = "Support team is required")
    private String supportTeam;

    @Size(max = 500, message = "Comments cannot exceed 500 characters")
    private String comments;


    public SystemDTO() {
    }

    public SystemDTO(System system) {
        this.id = system.getId();
        this.name = system.getName();
        this.description = system.getDescription();
        this.technicalLead = system.getTechnicalLead();
        this.functionalLead = system.getFunctionalLead();
        this.environments = system.getEnvironments();
        this.database = system.getDatabase();
        this.architectureType = system.getArchitectureType();
        this.programmingLanguage = system.getProgrammingLanguage();
        this.version = system.getVersion();
        this.status = system.getStatus();
        this.repositoryUrl = system.getRepositoryUrl();
        this.hosting = system.getHosting();
        this.supportTeam = system.getSupportTeam();
        this.comments = system.getComments();
    }

    public System toEntity() {
        System system = new System();
        system.setId(this.id);
        system.setName(this.name);
        system.setDescription(this.description);
        system.setTechnicalLead(this.technicalLead);
        system.setFunctionalLead(this.functionalLead);
        system.setEnvironments(this.environments);
        system.setDatabase(this.database);
        system.setArchitectureType(this.architectureType);
        system.setProgrammingLanguage(this.programmingLanguage);
        system.setVersion(this.version);
        system.setStatus(this.status);
        system.setRepositoryUrl(this.repositoryUrl);
        system.setHosting(this.hosting);
        system.setSupportTeam(this.supportTeam);
        system.setComments(this.comments);
        return system;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnicalLead() {
        return technicalLead;
    }

    public void setTechnicalLead(String technicalLead) {
        this.technicalLead = technicalLead;
    }

    public String getFunctionalLead() {
        return functionalLead;
    }

    public void setFunctionalLead(String functionalLead) {
        this.functionalLead = functionalLead;
    }

    public List<String> getEnvironments() {
        return environments;
    }

    public void setEnvironments(List<String> environments) {
        this.environments = environments;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public ArchitectureType getArchitectureType() {
        return architectureType;
    }

    public void setArchitectureType(ArchitectureType architectureType) {
        this.architectureType = architectureType;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public SystemStatus getStatus() {
        return status;
    }

    public void setStatus(SystemStatus status) {
        this.status = status;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getHosting() {
        return hosting;
    }

    public void setHosting(String hosting) {
        this.hosting = hosting;
    }

    public String getSupportTeam() {
        return supportTeam;
    }

    public void setSupportTeam(String supportTeam) {
        this.supportTeam = supportTeam;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
