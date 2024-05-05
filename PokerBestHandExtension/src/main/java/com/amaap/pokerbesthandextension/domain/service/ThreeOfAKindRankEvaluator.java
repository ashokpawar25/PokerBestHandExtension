package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.List;

public class ThreeOfAKindRankEvaluator implements RankEvaluator {
    private RankEvaluator nextEvaluator;

    @Override
    public HandRank getRank(List<CardDto> cards) {
        return isThreeOfAKindRank(cards) ? HandRank.THREEOFAKIND : ( nextEvaluator != null ? nextEvaluator.getRank(cards) : null);
    }

    private boolean isThreeOfAKindRank(List<CardDto> cards) {
        int count = 0;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(i).getRank().equals(cards.get(j).getRank())) {
                    count++;
                }
            }
        }
        return count >= 3;
    }

    @Override
    public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
        return this;
    }
}
