package com.example.todolistapp.controller;

import com.example.todolistapp.entity.TodoListEntity;
import com.example.todolistapp.service.TodolistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoListController {
 private final TodolistService todolistService;

    public TodoListController(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping("/getAll")
    public List<TodoListEntity> getAll(){
     return    todolistService.getTasks();
    }
    @GetMapping("/getById{id}")
    public TodoListEntity getBy(@PathVariable("id") Long id) throws Exception {
      return   todolistService.getTask(id);
    }
    @PostMapping("/add")
    public TodoListEntity add(@RequestBody TodoListEntity todoListEntity){
      return   todolistService.addTask(todoListEntity);
    }

    @PatchMapping ("updateStatus{id}")
    public void updateStatus(@PathVariable("id")Long id,@RequestBody Boolean taskstatus) throws Exception {
        todolistService.updateTaskStatus(id,taskstatus);
    }
    @DeleteMapping("/delete{id}")
    public void delete(@PathVariable Long id) throws Exception {
        todolistService.deleteTask(id);
    }
}
