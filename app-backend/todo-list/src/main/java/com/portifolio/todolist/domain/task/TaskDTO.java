package com.portifolio.todolist.domain.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private String title;
    private Optional<String> description;
    private Optional<Boolean> completed;
    private Optional<LocalDate> dueDate;

    public TaskDTO(TaskDTO taskDTO) {
        this.title = taskDTO.getTitle();
        this.description = taskDTO.getDescription();
        this.completed = taskDTO.getCompleted();
        this.dueDate = taskDTO.getDueDate();
    }
}
