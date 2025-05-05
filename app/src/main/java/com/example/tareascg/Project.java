package com.example.tareascg;


public class Project {
    private String title;
    private String description;
    private int imageResourceId;

    public Project(String title, String description, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getImageResourceId() { return imageResourceId; }
}