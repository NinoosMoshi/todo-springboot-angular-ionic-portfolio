package com.ninos.controller;

import com.ninos.model.Todo;
import com.ninos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @PostMapping("/todos")
    public Todo saveTodo(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }

   @GetMapping("/todo")
   public List<Todo> getAllTodo(){
        return todoRepository.findAll();
   }

   @GetMapping("/todo/{todoId}")
   public Optional getTodo(@PathVariable("todoId") Long todoId){
      var todo = todoRepository.findById(todoId);
      return todo;
   }



}
