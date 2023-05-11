package com.example.todolistapp.dto;

import lombok.Data;

@Data
public class TodoListDTO {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
}
