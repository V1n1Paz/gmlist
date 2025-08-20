package com.viniciuspaz.gmlist.repositories;

import com.viniciuspaz.gmlist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
