package com.amaap.pokerbesthandextension.controller;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.service.GameService;

public class GameController {
    private final GameService gameService;
    public GameController(GameService gameService) {
        this.gameService =gameService;
    }

    public HandRank checkRankFor(Hand hand) throws HandNotFoundException {
        return gameService.checkRankFor(hand);
    }
}
