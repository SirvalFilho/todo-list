package com.portifolio.todolist.advicer;

import com.portifolio.todolist.domain.task.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TaskNotFoundException.class)
  public Map<String,String> productNotFound(TaskNotFoundException ex) {
      Map<String,String> map = new HashMap<>();
      map.put("ERROR Message: ", ex.getMessage());
      return map;
  }
}
