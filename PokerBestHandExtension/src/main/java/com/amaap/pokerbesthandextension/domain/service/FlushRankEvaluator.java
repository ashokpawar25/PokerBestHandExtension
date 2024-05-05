package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.List;

public class FlushRankEvaluator implements RankEvaluator {
    private RankEvaluator nextEvaluator;

    @Override
    public HandRank getRank(List<CardDto> cards) {
        return isFlushRank(cards) ? HandRank.FLUSH : (nextEvaluator != null ? nextEvaluator.getRank(cards) : null);
    }

    private boolean isFlushRank(List<CardDto> cards) {
        String suit = cards.get(0).getSuit();
        for (CardDto card : cards) {
            if (!card.getSuit().equalsIgnoreCase(suit)) {
                return false;
            }
        }
        return true;
    }

    public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
        return this;
    }
}
