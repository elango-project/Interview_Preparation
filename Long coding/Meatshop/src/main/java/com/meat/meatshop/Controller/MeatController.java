package com.meat.meatshop.Controller;

import com.meat.meatshop.Entity.User;
import com.meat.meatshop.Service.MeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/meat")
public class MeatController {
    @Autowired
    private MeatService service;

    @PostMapping
    public User addUser(@RequestBody User u){
        return service.saveuser(u);
    }

    @GetMapping
    public List<User> viewAll(){
        return service.viewalluser();
    }

    @DeleteMapping("/{id}")
    public String deleteuser(@PathVariable int id){
        service.deleteuser(id);
        return "User is Deleted By ID!";
    }

    @GetMapping("/discount/{id}")
    public String discount(@PathVariable int id){
        return service.discount(id);
    }
}
