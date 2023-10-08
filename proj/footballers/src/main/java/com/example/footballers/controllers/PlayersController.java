package com.example.footballers.controllers;

import com.example.footballers.dto.PlayersDto;
import com.example.footballers.models.ErrorApiResponse;
import com.example.footballers.models.Players;
import com.example.footballers.services.interfaces.IPlayersService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/api/players")
public class PlayersController {

    private final IPlayersService _playersService;

    public PlayersController(IPlayersService playersService){
        _playersService = playersService;
    }

    @PutMapping()
    public ResponseEntity updatePlayerData(@RequestBody PlayersDto dto){
        try {
            Players player = _playersService.updatePlayerData(dto);
            return new ResponseEntity<Players>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            ErrorApiResponse error = new ErrorApiResponse();
            error.setErrorMsg(e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Players> addPlayerData(@RequestBody PlayersDto dto) {
        try {
            Players player = _playersService.addPlayerData(dto);
            return new ResponseEntity<Players>(HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<Players>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Players> delPlayerData(@PathVariable Integer id) {
        try {
            _playersService.deletePlayerData(id);
            return new ResponseEntity<Players>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<Players>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayersDto> getPlayerData(@PathVariable Integer id) {
        try {
            PlayersDto dto = _playersService.getPlayerData(id);
            return new ResponseEntity<PlayersDto>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<PlayersDto>(HttpStatus.NOT_FOUND);
        }
    }
}

