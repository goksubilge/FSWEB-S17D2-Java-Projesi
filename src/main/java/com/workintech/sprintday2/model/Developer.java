package com.workintech.sprintday2.model;

import java.util.Objects;

public class Developer {
    private int id;
    private String name;
    private int salary;
    private Experience experience;

    public Developer(int id, String name, int salary, Experience experience) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getSalary() {return salary;}
    public void setSalary(int salary) {this.salary = salary;}
    public Experience getExperience() {return experience;}
    public void setExperience(Experience experience) {this.experience = experience;}

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return id == developer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
