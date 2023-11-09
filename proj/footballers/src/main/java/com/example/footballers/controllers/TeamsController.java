package com.example.footballers.controllers;

import com.example.footballers.dto.TeamsDto;
import com.example.footballers.models.ErrorApiResponse;
import com.example.footballers.models.Teams;
import com.example.footballers.services.interfaces.ITeamsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/api/teams")
public class TeamsController {
    private final ITeamsService _teamsService;

    public TeamsController (ITeamsService teamsService) {
        _teamsService = teamsService;
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public Iterable<TeamsDto> getAllTeams() {
        return _teamsService.getAllTeams();
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping()
    public ResponseEntity<Teams> addNewTeam(@RequestBody TeamsDto dto) {
        try {
            Teams teams = _teamsService.AddNewTeam(dto);
            return new ResponseEntity<Teams>(HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<Teams>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTeamById(@PathVariable Integer id) {
        try {
            _teamsService.DeleteTeamById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            ErrorApiResponse error = new ErrorApiResponse();
            error.setErrorMsg(e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}
