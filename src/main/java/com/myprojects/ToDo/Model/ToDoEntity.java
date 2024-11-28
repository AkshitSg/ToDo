package com.myprojects.ToDo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class ToDoEntity {
    private int id;
    private String title;
    private String status;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "YYYY-MM-DD @ HH:MM:SS ")
    private Date createdDate=new Date();
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "YYYY-MM-DD @ HH:MM:SS ")
    private Date newDate=new Date();

    //    generating parameterized constructors
    public ToDoEntity(int id, String title, String status, String description, Date createdDate, Date newDate) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.description = description;
        this.createdDate = createdDate;
        this.newDate = newDate;
    }

    //    generating getters for all object members.
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getStatus() {
        return status;
    }
    public String getDescription() {
        return description;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public Date getNewDate() {
        return newDate;
    }

//    generating setters for all object members.
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }
    // generating toString() method
    // without it th output of printing instance will only be name and hashcode.
    @Override
    public String toString() {
        return "ToDoEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", newDate=" + newDate +
                '}';
    }

}
