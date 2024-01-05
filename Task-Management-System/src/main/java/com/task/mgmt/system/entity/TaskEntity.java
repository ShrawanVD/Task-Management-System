package com.task.mgmt.system.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "TasksTable")
public class TaskEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@Column(name = "title")
	@jakarta.validation.constraints.NotNull(message = "Title cannot be null")
	@NotEmpty(message = "title may not be empty")
    private String title;

    @Column(name = "description")
    @jakarta.validation.constraints.Size(max = 100, message = "Description should be at most 100 characters")
    private String description;

    @Column(name = "due_date")
    @jakarta.validation.constraints.NotNull
    private LocalDate dueDate;

    @Column(name = "priority")
    private String priority;

    @Column(name = "status")
    private String status;
    
    
    // Default constructor
    public TaskEntity() {
        
    }

    // parameterized constructor
    public TaskEntity(String title, String description, LocalDate dueDate, String priority, String status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
    }

    
    // Getters and setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
