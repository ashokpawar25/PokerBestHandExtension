package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.List;

public class StraightFlushRankEvaluator implements RankEvaluator{
    private RankEvaluator nextEvaluator;
    @Override
    public HandRank getRank(List<CardDto> cards) {
        return isStraightFlushRank(cards) ? HandRank.STRAIGHTFLUSH : (nextEvaluator != null ? nextEvaluator.getRank(cards) : null);
    }

    public boolean isStraightFlushRank(List<CardDto> cards)
    {
        StraightRankEvaluator straightRankEvaluator = new StraightRankEvaluator();
        FlushRankEvaluator flushRankEvaluator = new FlushRankEvaluator();
        HandRank straightRank = straightRankEvaluator.getRank(cards);
        HandRank flushRank = flushRankEvaluator.getRank(cards);
        return straightRank != null && flushRank != null;
    }
    @Override
    public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
        return this;
    }
}
