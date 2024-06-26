package com.amaap.pokerbesthandextension.controller;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.service.GameService;
import jakarta.inject.Inject;

public class GameController {
    private final GameService gameService;
    @Inject
    public GameController(GameService gameService) {
        this.gameService =gameService;
    }

    public HandRank checkRankFor(Hand hand) throws HandNotFoundException {
        return gameService.checkRankFor(hand);
    }

    public String getHighCard(Hand hand) throws HandNotFoundException {
        return gameService.getHighCard(hand);
    }
}
