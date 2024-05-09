package com.example.demo.controller;

import com.example.demo.model.Load;
import com.example.demo.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ApiController {
    @Autowired
    service apiService;

    @PostMapping("/load")
    public String addLoad(@RequestBody Load load){
        return apiService.addLoad(load);
    }

    @GetMapping("/load")
    public Optional<Load> getLoad(@RequestParam(name = "id")Long id){
        return apiService.getLoad(id);
    }

    @GetMapping("/load/{id}")
    public Optional<Load> getLoadById(@PathVariable Long id){
        return apiService.getLoadById(id);
    }

    @PutMapping("/load/{id}")
    public ResponseEntity<Load> updateLoad(@PathVariable Long id, @RequestBody Load updatedLoad) {
        Optional<Load> existingLoad = apiService.getLoadById(id);
        if (existingLoad.isPresent()) {
            updatedLoad.setId(id); // Ensure the ID in the payload matches the ID in the path
            Load savedLoad = apiService.saveLoad(updatedLoad);
            return ResponseEntity.ok(savedLoad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("load/{id}")
    public String deleteLoad(@PathVariable Long id){
        return apiService.deleteLoad(id);
    }
}
