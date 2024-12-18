package com.dsa.entities.schema;

import com.dsa.entities.enums.ArchitectureType;
import com.dsa.entities.enums.SystemStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "systems")
public class System {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private String technicalLead;

    @Column(nullable = false)
    private String functionalLead;

    @ElementCollection
    @CollectionTable(name = "system_environments", joinColumns = @JoinColumn(name = "system_id"))
    @Column(name = "environment")
    private List<String> environments;

    @Column(nullable = false)
    private String database;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ArchitectureType architectureType;

    @Column(nullable = false)
    private String programmingLanguage;

    @Column(nullable = false)
    private String version;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SystemStatus status;

    @Column(nullable = false)
    private String repositoryUrl;

    @Column(nullable = false)
    private String hosting;

    @Column(nullable = false)
    private String supportTeam;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(nullable = false) // Se actualiza automáticamente en inserciones y modificaciones
    private LocalDateTime lastUpdated;

    @Column(length = 500)
    private String comments;

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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}