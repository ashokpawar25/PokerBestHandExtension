package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.List;

public class PairRankEvaluator implements RankEvaluator {
    private RankEvaluator nextEvaluator;

    @Override
    public HandRank getRank(List<CardDto> cards) {
        if (isPairRank(cards)) {
            return HandRank.PAIR;
        } else if (nextEvaluator != null) {
            return nextEvaluator.getRank(cards);
        } else {
            return null;
        }
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
    public void setNextEvaluator(RankEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
    }
}
