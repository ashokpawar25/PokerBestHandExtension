package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.List;

public class HandEvaluatorChain {
    RankEvaluator rankEvaluator;
    public HandEvaluatorChain()
    {
        this.rankEvaluator = new FlushRankEvaluator();
        this.rankEvaluator.setNextEvaluator(new PairRankEvaluator());
    }
    public HandRank getRank(List<CardDto> cards) {
        return rankEvaluator.getRank(cards);
    }
}
