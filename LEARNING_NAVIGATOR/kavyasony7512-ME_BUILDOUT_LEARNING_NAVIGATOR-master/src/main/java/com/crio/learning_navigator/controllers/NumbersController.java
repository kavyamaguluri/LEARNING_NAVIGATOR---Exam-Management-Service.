package com.crio.learning_navigator.controllers;

import java.util.HashMap;
import java.util.Map;
import com.crio.learning_navigator.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumbersController {
    
    @Autowired
    private NumberService numberServices;
    
    @GetMapping("/easter-egg/hidden-feature/{number}")
public ResponseEntity<Map<String, String>> getRandomNumberFact(@PathVariable int number) {
    String fact = numberServices.getNumberFact(number);
    Map<String, String> response = new HashMap<>();
    response.put("message", "Great! You have found the hidden number fact ");
    response.put("response", fact);
    return ResponseEntity.ok(response);
}
    
}
