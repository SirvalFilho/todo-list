package com.portifolio.todolist.domain.task;

public class TaskNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Task not found";
    }
}
