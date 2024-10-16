package com.portifolio.todolist.domain.task;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Boolean completed;

    private LocalDate dueDate;

    @PrePersist
    public void prePersist() {
        if (this.dueDate == null) {
            this.dueDate = LocalDate.now();
        }
    }

    public Task(TaskDTO data) {
        this.title = data.getTitle();
        this.description = data.getDescription().get();
        this.completed = data.getCompleted().get();
        this.dueDate = data.getDueDate().get();
    }
}