package com.workintech.sprintday2.dto;

import com.workintech.sprintday2.model.Developer;

public class DevResponse {
    private Developer developer;
    private String message;
    private int status;

    public DevResponse(Developer developer, String message, int status) {
        this.developer = developer;
        this.message = message;
        this.status = status;
    }

    public Developer getDeveloper() {return developer;}
    public String getMessage() {return message;}
    public int getStatus() {return status;}
}
