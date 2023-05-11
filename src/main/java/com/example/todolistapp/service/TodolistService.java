package com.example.todolistapp.service;

import com.example.todolistapp.entity.TodoListEntity;
import com.example.todolistapp.repository.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodolistService {
    private final TodoListRepository todoListRepository;

    public TodolistService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public TodoListEntity addTask(TodoListEntity todoListEntity){
        todoListRepository.save(todoListEntity);
        return  todoListEntity;
    }

    public TodoListEntity getTask(Long id ) throws Exception {
        return todoListRepository.findById(id).orElseThrow(Exception::new);
    }

    public void updateTaskStatus(Long id ,Boolean status) throws Exception {
        TodoListEntity booksEntity = todoListRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo item not found"));
        booksEntity.setCompleted(status);
        todoListRepository.save(booksEntity);
    }
    public void deleteTask(Long id) throws Exception {
    todoListRepository.delete(todoListRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo item not found")));
    }

    public List<TodoListEntity> getTasks() {
        return todoListRepository.findAll();
    }

}
