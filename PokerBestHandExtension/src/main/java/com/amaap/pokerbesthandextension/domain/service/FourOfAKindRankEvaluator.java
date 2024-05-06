package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourOfAKindRankEvaluator implements RankEvaluator {
    private RankEvaluator nextEvaluator;

    @Override
    public HandRank getRank(List<CardDto> cards) {
        return isFourOfAKindRank(cards) ? HandRank.FOUROFAKIND : (nextEvaluator != null ? nextEvaluator.getRank(cards) : null);
    }

    private boolean isFourOfAKindRank(List<CardDto> cards) {
        Map<String, Integer> count = new HashMap<>();
        for (CardDto card : cards) {
            String rank = card.getRank();
            if (count.containsKey(rank)) {
                int frequency = count.get(rank);
                count.put(rank, ++frequency);
            } else{
                count.put(rank,1);
            }
        }
        for(int frequency: count.values())
        {
            if(frequency == 4) return true;
        }
        return false;
    }

    @Override
    public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
        return this;
    }
}
