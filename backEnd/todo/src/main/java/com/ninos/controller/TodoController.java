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
   public Optional<Todo> getTodo(@PathVariable("todoId") Long todoId){
      var todo = todoRepository.findById(todoId);
      return todo;
   }


    @PutMapping("/update/{todoId}")
    public Optional<Todo> editTodo(@PathVariable("todoId") Long todoId, @RequestBody Todo updatedTodo){
       return todoRepository.findById(todoId)
               .map(oldTodo -> todoRepository.save(updatedTodo));
    }


    @DeleteMapping("/delete/{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId){
        todoRepository.deleteById(todoId);
    }



}
