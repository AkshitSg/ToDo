package com.myprojects.ToDo;

import com.myprojects.ToDo.Model.ToDoEntity;
import com.myprojects.ToDo.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    private final ToDoService toDoService;
    @Autowired //Controller mapping best approach(injection explicitly, class immutable)
    public ToDoController(ToDoService toDoService){
        this.toDoService=toDoService;
    }

    @PostMapping("/create")
    ResponseEntity<String> createToDo(@RequestBody ToDoEntity toDoEntity){
        ToDoEntity toDo=toDoService.createToDo(toDoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Todo is created successfully.");
    }

    @GetMapping("/list")
    ResponseEntity<List<ToDoEntity>> getTodoList(){
        List<ToDoEntity> toDoList=toDoService.getAllToDos();
        return ResponseEntity.ok(toDoList);
    }

    @GetMapping("/getTodo/{id}")
    ResponseEntity<ToDoEntity> getTodoById(@PathVariable int id){
        ToDoEntity toDo=toDoService.getSingleToDo(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(toDo);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<String> updateTodo(@PathVariable int id,@RequestBody ToDoEntity toDo){
        ToDoEntity updateToDo=toDoService.updateToDo(id,toDo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Todo was updated successfully.");
    }

    @DeleteMapping("/reset")
    ResponseEntity<String> clearToDoList(){
        toDoService.deleteAllToDos();
        return ResponseEntity.status(HttpStatus.OK).body("Todo list is empty now. All todos deleted.");
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteTodoById(@PathVariable int id){
        toDoService.deleteToDo(id);
        return ResponseEntity.status(HttpStatus.OK).body("Todo was deleted successfully.");
    }
}
