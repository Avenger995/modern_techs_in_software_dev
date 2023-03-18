package com.example.footballers.controllers;

import com.example.footballers.dto.PlayersDto;
import com.example.footballers.models.Players;
import com.example.footballers.services.interfaces.IPlayersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/api/players")
public class PlayersController {

    private final IPlayersService _playersService;

    public PlayersController(IPlayersService playersService){
        _playersService = playersService;
    }

    @GetMapping("/byId/{id}")
    public Iterable<PlayersDto> getAllPlayers(@PathVariable Integer id){
        return _playersService.getPlayersByTeamId(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Players> updatePlayerData(@RequestBody Map<String, Object> dto){
        try {
            Players player = _playersService.updatePlayerData(dto);
            return new ResponseEntity<Players>(HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<Players>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Players> addPlayerData(@RequestBody Map<String, Object> dto) {
        try {
            Players player = _playersService.addPlayerData(dto);
            return new ResponseEntity<Players>(HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<Players>(HttpStatus.BAD_REQUEST);
        }
    }
}

