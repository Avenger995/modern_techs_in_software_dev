package com.example.footballers.controllers;

import com.example.footballers.dto.TeamsDto;
import com.example.footballers.models.Teams;
import com.example.footballers.services.interfaces.ITeamsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/api/teams")
public class TeamsController {
    private final ITeamsService _teamsService;

    public TeamsController (ITeamsService teamsService) {
        _teamsService = teamsService;
    }

    @GetMapping
    public Iterable<TeamsDto> getAllTeams() {
        return _teamsService.getAllTeams();
    }


    @PostMapping("/add")
    public ResponseEntity<Teams> addNewTeam(@RequestBody Map<String, Object> dto) {
        try {
            Teams teams = _teamsService.AddNewTeam(dto);
            return new ResponseEntity<Teams>(HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<Teams>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Teams> deleteTeamById(@PathVariable int id) {
        try {
            _teamsService.DeleteTeamById(id);
            return new ResponseEntity<Teams>(HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<Teams>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
