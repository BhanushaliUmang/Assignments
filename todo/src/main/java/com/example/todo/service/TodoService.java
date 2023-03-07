package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

   
    public List<Todo> findAll() { 
        return todoRepository.findAll();
    }


   
    public Todo findById(int id) { 
        
        return todoRepository.findById(id).get();
    }

    public void addTodo(Todo todo) {
        
        todoRepository.save(todo);
    }

    
    public void deleteTodo(int id) {
      
        todoRepository.deleteById(id);
    }

    
    public void updateTodo(int id,Todo newTodo) {
        
       Todo todo= todoRepository.findById(id).get();
       todo.setId(newTodo.getId());
         todo.setTitle(newTodo.getTitle());
         todo.setStatus(newTodo.isStatus());
         todoRepository.save(todo);


    }
}
