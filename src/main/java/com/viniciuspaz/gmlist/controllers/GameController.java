package com.viniciuspaz.gmlist.controllers;

import com.viniciuspaz.gmlist.dto.GameDTO;
import com.viniciuspaz.gmlist.dto.GameMinDTO;
import com.viniciuspaz.gmlist.entities.Game;
import com.viniciuspaz.gmlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500") // ou a porta do Live Server
@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
