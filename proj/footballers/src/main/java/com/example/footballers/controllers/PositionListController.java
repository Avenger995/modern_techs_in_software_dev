package com.example.footballers.controllers;

import com.example.footballers.dto.PositionListDto;
import com.example.footballers.models.PositionList;
import com.example.footballers.services.interfaces.IPositionsListService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", exposedHeaders = "*")
@RequestMapping("/api/positions")
public class PositionListController {
    private final IPositionsListService _positionsListService;

    public PositionListController(IPositionsListService positionsListService){
        _positionsListService = positionsListService;
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping()
    public Iterable<PositionListDto> getAllPositions(){
        return _positionsListService.getAllPositionList();
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("by-team/{id}")
    public Iterable<PositionListDto> getPositionsByTeam(@PathVariable Integer id){
        return _positionsListService.getAllPositionListByTeam(id);
    }
}
