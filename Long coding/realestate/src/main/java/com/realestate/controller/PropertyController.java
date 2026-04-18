package com.realestate.controller;

import com.realestate.model.Property;
import com.realestate.repository.PropertyRepository;
import com.realestate.service.MortgageAndTrustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "*")
public class PropertyController {

    @Autowired
    private PropertyRepository repository;

    @Autowired
    private MortgageAndTrustService service;

    @GetMapping
    public List<Map<String, Object>> getAllAnalyzedProperties() {
        List<Property> properties = repository.findAll();
        List<Map<String, Object>> responseList = new ArrayList<>();

        for (Property p : properties) {
            Map<String, Object> map = new HashMap<>();
            map.put("details", p);
            map.put("analysis", service.analyzeProperty(p));
            responseList.add(map);
        }
        return responseList;
    }
}