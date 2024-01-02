package com.workintech.sprintday2.model;

import com.workintech.sprintday2.tax.Taxable;

public class CreateDeveloper {
    public static Developer nettoDeveloper(Developer developer, Taxable taxable){
        Developer newDeveloper = null;
        if(developer.getExperience().name().equalsIgnoreCase("junior")){
            newDeveloper = new JuniorDev(developer.getId(), developer.getName(), developer.getSalary()  - (developer.getSalary()*taxable.getSimpleTaxRate()));
        } else if(developer.getExperience().name().equalsIgnoreCase("mid")){
            newDeveloper = new MidDev(developer.getId(), developer.getName(), developer.getSalary()  - (developer.getSalary()*taxable.getMiddleTaxRate()));
        } else if(developer.getExperience().name().equalsIgnoreCase("senior")){
            newDeveloper = new SeniorDev(developer.getId(), developer.getName(), developer.getSalary()  - (developer.getSalary()*taxable.getUpperTaxRate()));
        } return newDeveloper;
    }
}