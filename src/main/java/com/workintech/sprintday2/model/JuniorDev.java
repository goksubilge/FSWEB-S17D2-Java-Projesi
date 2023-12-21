package com.workintech.sprintday2.model;

public class JuniorDev extends Developer {
    public JuniorDev(int id, String name, double salary) {

        super(id, name, salary, Experience.JUNIOR);
    }
}
