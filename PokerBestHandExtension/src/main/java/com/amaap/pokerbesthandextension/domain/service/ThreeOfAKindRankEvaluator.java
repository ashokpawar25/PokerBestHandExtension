package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.List;

public class ThreeOfAKindRankEvaluator implements RankEvaluator {
    private RankEvaluator nextEvaluator;

    @Override
    public HandRank getRank(List<CardDto> cards) {
        if (isThreeOfAKindRank(cards)){
            return HandRank.THREEOFAKIND;
        }
        else if (nextEvaluator != null) {
            return nextEvaluator.getRank(cards);
        } else {
            return null;
        }
    }

    private boolean isThreeOfAKindRank(List<CardDto> cards) {
        CardDto[] cardsArray = cards.toArray(new CardDto[0]);
        int count = 0;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                if (cardsArray[i].getRank().equalsIgnoreCase(cardsArray[j].getRank())) {
                    count++;
                }
            }
        }
        if (count >= 3) return true;
        return false;
    }

    @Override
    public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
        return this;
    }
}
