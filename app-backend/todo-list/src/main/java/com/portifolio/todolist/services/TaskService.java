package com.portifolio.todolist.services;

import com.portifolio.todolist.domain.task.Task;
import com.portifolio.todolist.domain.task.TaskDTO;
import com.portifolio.todolist.domain.task.TaskNotFoundException;
import com.portifolio.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> insert(TaskDTO task) {
        Task newTask = new Task(task);
        this.taskRepository.save(newTask);
        return this.findAllTasks();
    }

    public Task update(Long id , TaskDTO task) {
        //Caso não encontre uma exceção é lançada
        Task currentTask = this.taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);


        //Atualizando informações
        Task updatedTask = currentTask;
        updatedTask.setTitle(task.getTitle());
        if(task.getDescription().isPresent()){updatedTask.setDescription(task.getDescription().get());}
        if(task.getDueDate().isPresent()){updatedTask.setDueDate(task.getDueDate().get());}
        if(task.getCompleted().isPresent()){updatedTask.setCompleted(task.getCompleted().get());}

        this.taskRepository.save(updatedTask);
        return updatedTask;

    }

    public List<Task> delete(Long id) {
        //Caso não encontre uma exceção é lançada
        Task currentTask = this.taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
        this.taskRepository.deleteById(id);
        return this.findAllTasks();
    }

    public List<Task> findAllTasks() {
        Sort sort = Sort.by(Sort.Direction.DESC, "dueDate");
        return taskRepository.findAll(sort);
    }
}
