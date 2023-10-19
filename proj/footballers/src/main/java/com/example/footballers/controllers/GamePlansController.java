package com.example.footballers.controllers;

import com.example.footballers.dto.GamePlansDto;
import com.example.footballers.dto.TeamsDto;
import com.example.footballers.models.ErrorApiResponse;
import com.example.footballers.models.GamePlans;
import com.example.footballers.services.interfaces.IGamePlanService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/api/game-plan")
public class GamePlansController {

    private final IGamePlanService _gamePlanService;

    public GamePlansController(IGamePlanService gamePlanService) {
        _gamePlanService = gamePlanService;
    }

    @PostMapping()
    public ResponseEntity<?> addGamePlan(@RequestBody GamePlansDto dto) {
        try {
            Integer res = _gamePlanService.addNewGamePlan(dto);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<GamePlans>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/by-team/{teamId}")
    public Iterable<GamePlansDto> getAllGamePlans(@PathVariable Integer teamId) {
        return _gamePlanService.getAllGamePlansByTeam(teamId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGamePlanById(@PathVariable Integer id) {
        try {
            _gamePlanService.deleteGamePlanById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            ErrorApiResponse error = new ErrorApiResponse();
            error.setErrorMsg(e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}
