package com.viniciuspaz.gmlist.services;

import com.viniciuspaz.gmlist.dto.GameListDTO;
import com.viniciuspaz.gmlist.entities.GameList;
import com.viniciuspaz.gmlist.projections.GameMinProjection;
import com.viniciuspaz.gmlist.repositories.GameListRepository;
import com.viniciuspaz.gmlist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.PropertyEditorSupport;
import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameRepository gameRepository;

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

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }


    }


}
