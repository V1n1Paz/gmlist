package com.viniciuspaz.gmlist.repositories;

import com.viniciuspaz.gmlist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
