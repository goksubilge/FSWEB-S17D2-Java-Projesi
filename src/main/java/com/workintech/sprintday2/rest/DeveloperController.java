package com.workintech.sprintday2.rest;

import com.workintech.sprintday2.model.CreateDeveloper;
import com.workintech.sprintday2.model.Developer;
import com.workintech.sprintday2.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController // for controller
@RequestMapping("/developers") // for endpoint change

public class DeveloperController {
private Map<Integer, Developer> developers;
private Taxable taxable;

@PostConstruct
    public void postConst (){
    developers = new HashMap<>();
}
@Autowired
    public DeveloperController(Taxable taxable) {
        this.taxable = taxable;
    }
@PostMapping("/")
    public Developer save(@RequestBody Developer developer){
    Developer savedDeveloper = CreateDeveloper.nettoDeveloper(developer,taxable);
    //Validation:
    if(savedDeveloper != null){
        developers.put(savedDeveloper.getId(), savedDeveloper);
    }
    return  savedDeveloper;
    }

@GetMapping("/")
    public List<Developer> get(){
    return developers.values().stream().toList();
}

}