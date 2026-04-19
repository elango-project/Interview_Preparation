package com.realestate.controller;

import com.realestate.dto.AnalysisRequest;
import com.realestate.dto.PropertyAnalysisResponse;
import com.realestate.service.PropertyAnalysisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin
public class PropertyController {

    private final PropertyAnalysisService service;

    public PropertyController(PropertyAnalysisService service) {
        this.service = service;
    }

    @PostMapping("/analyze")
    public List<PropertyAnalysisResponse> analyzeProperties(@RequestBody AnalysisRequest request) {
        System.out.println("API HIT");
        return service.analyzeAllProperties(request);
    }
}