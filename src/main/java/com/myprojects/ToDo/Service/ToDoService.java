package com.myprojects.ToDo.Service;


import com.myprojects.ToDo.Model.ToDoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ToDoService {
    // Method declaration for CRUD operations.
    public ToDoEntity createToDo(ToDoEntity toDoEntity);
    public ToDoEntity getSingleToDo(int toDoId);
    public List<ToDoEntity> getAllToDos();
    public ToDoEntity updateToDo(int toDoId,ToDoEntity toDoEntity);
    public void deleteToDo(int toDoId);
    public void deleteAllToDos();

}
