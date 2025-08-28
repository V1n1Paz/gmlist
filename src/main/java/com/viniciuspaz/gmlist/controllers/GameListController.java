package com.viniciuspaz.gmlist.controllers;

import com.viniciuspaz.gmlist.dto.GameListDTO;
import com.viniciuspaz.gmlist.dto.GameMinDTO;
import com.viniciuspaz.gmlist.dto.ReplacementDTO;
import com.viniciuspaz.gmlist.services.GameListService;
import com.viniciuspaz.gmlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500") // ou a porta do Live Server
@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListDTO getById(@PathVariable Long id){
        GameListDTO result = gameListService.getById(id);
        return result;
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result =  gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move (@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
