package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.List;

public class HandEvaluatorChain {
    RankEvaluator rankEvaluator;
    public HandEvaluatorChain()
    {
        this.rankEvaluator = new FourOfAKindRankEvaluator()
                .setNextEvaluator(new ThreeOfAKindRankEvaluator()
                        .setNextEvaluator(new PairRankEvaluator()
                                .setNextEvaluator(new StraightFlushRankEvaluator()
                                .setNextEvaluator(new StraightRankEvaluator()
                                .setNextEvaluator(new FlushRankEvaluator())))));
    }
    public HandRank getRank(List<CardDto> cards) {
        return rankEvaluator.getRank(cards);
    }
}
