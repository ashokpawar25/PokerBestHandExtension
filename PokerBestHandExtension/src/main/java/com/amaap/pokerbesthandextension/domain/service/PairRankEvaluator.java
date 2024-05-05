package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.List;

public class PairRankEvaluator implements RankEvaluator {
    private RankEvaluator nextEvaluator;

    @Override
    public HandRank getRank(List<CardDto> cards) {
        return isPairRank(cards) ? HandRank.PAIR : (nextEvaluator != null ? nextEvaluator.getRank(cards) : null);
    }

    private boolean isPairRank(List<CardDto> cards) {
        CardDto[] cardsArray = cards.toArray(new CardDto[0]);
        for (int i = 0; i < cardsArray.length; i++) {
            for (int j = i + 1; j < cardsArray.length; j++) {
                if (cardsArray[i].getRank().equalsIgnoreCase(cardsArray[j].getRank())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
        return this;
    }
}
