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

@Autowired   // taxable = new DeveloperTax()    ( Bu dersin özelliği autowired 'in bunu yapabilmesi)
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
@GetMapping("/{id}")
    public Developer getById(@PathVariable int id){
    return developers.get(id);
}

@PutMapping("/{id}") // (get hariç id yönetimini sql veritabanına atacağım, böylece orada tutulacak ben set'lerle çalışmayacağım burada)
    public Developer update(@PathVariable int id, @RequestBody Developer developer){
    Developer updatedDveloper = CreateDeveloper.nettoDeveloper(developer, taxable);
    developers.put(id,updatedDveloper);
    return updatedDveloper;
}

@DeleteMapping("/{id}")
    public Developer remove(@PathVariable int id){
    Developer removedDeveloper = developers.get(id);
    developers.remove(id);
    return removedDeveloper;
}
}