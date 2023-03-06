package com.example.TodoApp.service;

import com.example.TodoApp.model.Todo;
import com.example.TodoApp.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos=new ArrayList<>(); // In-memory database

    @Autowired
    private TodoRepo todoRepo;


    public List<Todo> findAll() { // Business Logic
        return todoRepo.findAll();
    }


    public Todo findById(int id) { // business Logic
        return todoRepo.findById(id).get();
    }


    public void addTodo(Todo todo) {
        todoRepo.save(todo);
    }


    public void deleteTodo(int id) {
        todoRepo.deleteById(id);
    }


    public void updateTodo(int id,Todo newTodo) {
        //step 1: find todo to be update
        //Step 2: update todo

        Todo todo=todoRepo.findById(id).get();

        todo.setId(newTodo.getId());
        todo.setTitle(newTodo.getTitle());
        todo.setStatus(newTodo.isStatus());

        todoRepo.save(todo);
    }
}
