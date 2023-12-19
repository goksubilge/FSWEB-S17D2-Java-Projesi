package com.workintech.sprintday2.model;

public class JuniorDev extends Developer {
    public JuniorDev(int id, String name, int salary) {

        super(id, name, salary, Experience.JUNIOR);
    }
}
