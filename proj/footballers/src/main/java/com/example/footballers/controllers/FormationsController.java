package com.example.footballers.controllers;

import com.example.footballers.dto.FormationsDto;
import com.example.footballers.services.interfaces.IFormationsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/api/formations")
public class FormationsController {

    private final IFormationsService _formationsService;

    public FormationsController(IFormationsService formationsService) {
        this._formationsService = formationsService;
    }

    @GetMapping
    public Iterable<FormationsDto> getAllFormations() {
        return _formationsService.getAll();
    }
}
