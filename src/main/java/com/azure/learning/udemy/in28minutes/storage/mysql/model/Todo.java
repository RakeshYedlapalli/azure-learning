package com.azure.learning.udemy.in28minutes.storage.mysql.model;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;

//@Entity
public class Todo {

    public Todo() {
    }

    public Todo(Long id, String description, String details, boolean done) {
        this.id = id;
        this.description = description;
        this.details = details;
        this.done = done;
    }

//    @Id
    private Long id;

    private String description;

    private String details;

    private boolean done;


}
