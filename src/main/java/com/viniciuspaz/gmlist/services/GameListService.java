package com.viniciuspaz.gmlist.services;

import com.viniciuspaz.gmlist.dto.GameListDTO;
import com.viniciuspaz.gmlist.entities.GameList;
import com.viniciuspaz.gmlist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.PropertyEditorSupport;
import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public GameListDTO getById(Long id){
        GameList result = gameListRepository.findById(id).get();
        GameListDTO dto = new GameListDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }


}
