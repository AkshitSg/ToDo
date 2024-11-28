package com.myprojects.ToDo.Service.Impl;

import com.myprojects.ToDo.Model.ToDoEntity;
import com.myprojects.ToDo.Service.ToDoService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {

//    Creating innerDB(List) to store toDos.
    List<ToDoEntity> toDoList=new LinkedList<>();
    public ToDoEntity createToDo(ToDoEntity toDoEntity) {
        toDoList.add(toDoEntity);
        return toDoEntity;
    }
    public ToDoEntity getSingleToDo(int toDoId) {

        ToDoEntity toDoFound=null;

//    ****brute-force logic****
//        for(ToDoEntity t:toDoList){
//            if(t.getId()==toDoId){
//                toDoFound=t;
//                break;
//            }
//        }
//        if (toDoFound==null){
//            throw new ResourceNotFoundException("ToDo not found.");
//        }
//    return toDoFound;

//        Using JAVA 8 methods
        toDoFound=toDoList.stream()      // converts collection in stream.
                .filter((t)->{return t.getId()==toDoId;})     // returns filtered stream on basis of given condition in predicate function.
                .findAny()              // grabs any element from the stream.
                .orElseThrow(()->{return new ResourceNotFoundException("ToDo not found");});
        return toDoFound;
    }
    public List<ToDoEntity> getAllToDos() {
        return toDoList;
    }
    public ToDoEntity updateToDo(int toDoId, ToDoEntity toDoEntity) {

        ToDoEntity updatedTodo = toDoList.stream()
                .filter((t) -> {
                    return t.getId() == toDoId;
                })
                .findFirst()
                .map((t) -> {
                    t.setTitle(toDoEntity.getTitle());
                    t.setDescription(toDoEntity.getDescription());
                    t.setStatus(toDoEntity.getStatus());
                    t.setNewDate(new Date());
                    return t;
                }).orElseThrow(()->{return new ResourceNotFoundException("Could not update ToDo with: "+toDoId+", please enter correct id.");});
        return updatedTodo;
    }
    public void deleteToDo(int toDoId) {
        List<ToDoEntity> newToDoList=toDoList.stream()
                .filter((t)->{return t.getId()!=toDoId;})
                .collect(Collectors.toList());
        toDoList=newToDoList;
    }
    public void deleteAllToDos() {
        toDoList.clear();
    }
}
