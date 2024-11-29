package com.myprojects.ToDo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ToDo_List")
public class ToDoJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "todo_id")
    private int id;
    @Column(name = "todo_title")
    private String title;
    @Column(name="todo_status")
    private String status;
    @Column(name = "todo_description")
    private String description;
    @Column(name = "created_date")
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern = "YYYY-MM-DD")
    Date addedDate=new Date();
    @Column(name = "modified_date")
    @JsonFormat(shape =JsonFormat.Shape.STRING,pattern = "YYYY-MM-DD")
    Date updatedDate=new Date();

    public ToDoJpaEntity(int id, String title, String status, String description, Date addedDate, Date updatedDate) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.description = description;
        this.addedDate = addedDate;
        this.updatedDate = updatedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "ToDoJpaEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", addedDate=" + addedDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
