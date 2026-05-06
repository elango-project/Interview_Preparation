package com.meat.meatshop.Service;

import com.meat.meatshop.Entity.User;
import com.meat.meatshop.Repository.MeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeatService {
    @Autowired
    private MeatRepository repo;

    public User saveuser(User u){
        return repo.save(u);
    }

    public List<User> viewalluser() {
        return repo.findAll();
    }

    public void deleteuser(int id) {
        if(!repo.existsById(id)){
            throw new RuntimeException("ID Not Found!");
        }
        repo.deleteById(id);
    }

    public String discount(int id){
        User u=repo.findById(id).orElse(null);
        if(u!=null&&u.getUser_address()!=null && u.getUser_address().toLowerCase().contains("trichy")){
            return "You Got Discount!";
        }
        return "no Discount";
    }
}

