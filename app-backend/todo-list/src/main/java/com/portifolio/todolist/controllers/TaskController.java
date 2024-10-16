package com.portifolio.todolist.controllers;

import com.portifolio.todolist.domain.task.Task;
import com.portifolio.todolist.domain.task.TaskDTO;
import com.portifolio.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = this.taskService.findAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/add")
    public ResponseEntity<List<Task>> addNewTask(@RequestBody TaskDTO task) {
        List<Task> tasks = this.taskService.insert(task);
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody TaskDTO task) {
        Task updateTask = this.taskService.update(id, task);
        return ResponseEntity.ok(updateTask);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Task>> deleteTask(@PathVariable Long id) {
        List<Task> tasks = this.taskService.delete(id);
        return ResponseEntity.ok(tasks);
    }
}
