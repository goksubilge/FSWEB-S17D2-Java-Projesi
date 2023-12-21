package com.workintech.sprintday2.model;

public class SeniorDev extends Developer{
    public SeniorDev(int id, String name, double salary) {
        super(id, name, salary, Experience.SENIOR);
    }
}
