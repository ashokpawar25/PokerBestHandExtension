package com.amaap.pokerbesthandextension.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.domain.service.HandEvaluatorChain;
import com.amaap.pokerbesthandextension.domain.service.HighCardEvaluator;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;

import java.util.List;

public class GameService {
    private final HandEvaluatorChain handEvaluatorChain;
    private final HandService handService;
    public GameService(HandEvaluatorChain handEvaluatorChain, HandService handService) {
        this.handEvaluatorChain = handEvaluatorChain;
        this.handService = handService;
    }

    public HandRank checkRankFor(Hand hand) throws HandNotFoundException {
        List<CardDto> cards = handService.getCardsForHand(hand);
        return handEvaluatorChain.getRank(cards);
    }

    public String getHighCard(Hand hand) throws HandNotFoundException {
        List<CardDto> cards = handService.getCardsForHand(hand);
        return HighCardEvaluator.getHighCard(cards);
    }
}
