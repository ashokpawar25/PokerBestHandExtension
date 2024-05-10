package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.List;

public class PairRankEvaluator implements RankEvaluator {

    @Override
    public HandRank getRank(List<CardDto> cards) {
        return isPairRank(cards) ? HandRank.PAIR : HandRank.HIGHCARD;
    }

    private boolean isPairRank(List<CardDto> cards) {
        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                if (cards.get(i).getRank().equals(cards.get(j).getRank())) return true;
            }
        }
        return false;
    }

    @Override
    public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator) {
        return null;
    }
}
