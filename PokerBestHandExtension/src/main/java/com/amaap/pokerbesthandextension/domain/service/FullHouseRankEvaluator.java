package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullHouseRankEvaluator implements RankEvaluator {
    private RankEvaluator nextEvaluator;

    @Override
    public HandRank getRank(List<CardDto> cards) {
        return isFullHouse(cards) ? HandRank.FULLHOUSE : (nextEvaluator != null ? nextEvaluator.getRank(cards) : null);
    }

    private boolean isFullHouse(List<CardDto> cards) {
        Map<String, Integer> rankCount = new HashMap<>();
        boolean isCountTwo = false;
        boolean isCountThree = false;
        for (CardDto card : cards) {
            String rank = card.getRank();
            if (rankCount.containsKey(rank)) {
                int count = rankCount.get(rank);
                rankCount.put(rank, ++count);
            } else {
                rankCount.put(rank, 1);
            }
        }
        if (rankCount.size() > 2) return false;
        for (int count : rankCount.values()) {
            if (count == 2) isCountTwo = true;
            else if (count == 3) isCountThree = true;
        }
        return isCountTwo && isCountThree;
    }

    @Override
    public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
        return this;
    }
}
