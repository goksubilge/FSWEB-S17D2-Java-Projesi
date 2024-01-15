package com.workintech.sprintday2.validation;

import com.workintech.sprintday2.model.Developer;

import java.util.Map;

public class DevValidation {
    public static boolean isDeveloperExist(Map<Integer, Developer> developers, int id){
        return developers.containsKey(id);  // exist ? => true
    }
}
