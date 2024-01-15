package com.workintech.sprintday2.rest;

import com.workintech.sprintday2.dto.DevResponse;
import com.workintech.sprintday2.model.CreateDeveloper;
import com.workintech.sprintday2.model.Developer;
import com.workintech.sprintday2.tax.Taxable;
import com.workintech.sprintday2.validation.DevValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@ResponseStatus(HttpStatus.CREATED) // success state lerde çalışacak response ne olacak diye seçtim. başarılı create (Post ta 201 döndürüyor bu seçim)  // Note 1:  Post, create, save => success => 201    // Note 2:  Read, get => 200 döndürür
    public DevResponse save(@RequestBody Developer developer){
    // dto
    if(DevValidation.isDeveloperExist(developers, developer.getId())){
        return new DevResponse(null, "Developer with given id (Post) already exist: " + developer.getId(), 400);
    }
    Developer savedDeveloper = CreateDeveloper.nettoDeveloper(developer,taxable);
    //Validation:
    if(savedDeveloper != null){
        developers.put(savedDeveloper.getId(), savedDeveloper);
    }
    return new DevResponse(savedDeveloper, "Success" ,200);
    }

@GetMapping("/")
    public List<Developer> get(){
    return developers.values().stream().toList();
}
@GetMapping("/{id}")  // validation and dto    // public Developer getById yerine DevResponse döndürüyorum, dto için. buna da bir if yazıyorum.
    public DevResponse getById(@PathVariable int id) {
    if (DevValidation.isDeveloperExist(developers, id)) {
        return new DevResponse(developers.get(id), "Success", 200);
    }
    return new DevResponse(null,"Dev w given id (Get) is not exist: " + id, 404);
}

@PutMapping("/{id}") // (get hariç id yönetimini sql veritabanına atacağım, böylece orada tutulacak ben set'lerle çalışmayacağım burada)
    public DevResponse update(@PathVariable int id, @RequestBody Developer developer){
    if(!DevValidation.isDeveloperExist(developers,id)){
        return new DevResponse(null, "Dev w given id (Put) is not exist: " + id, 404);
    }
    Developer updatedDeveloper = CreateDeveloper.nettoDeveloper(developer, taxable);
    developers.put(id,updatedDeveloper);
    return new DevResponse(updatedDeveloper, " Put Success", 200);
}

@DeleteMapping("/{id}")
    public Developer remove(@PathVariable int id){
    Developer removedDeveloper = developers.get(id);
    developers.remove(id);
    return removedDeveloper;
}
}