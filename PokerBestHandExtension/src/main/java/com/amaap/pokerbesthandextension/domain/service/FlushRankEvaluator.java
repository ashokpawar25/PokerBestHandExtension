package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.List;

public class FlushRankEvaluator implements RankEvaluator {
    private RankEvaluator nextEvaluator;
    @Override
    public HandRank getRank(List<CardDto> cards) {
        if(isFlushRank(cards)) return HandRank.FLUSH;
        return null;
    }

    private boolean isFlushRank(List<CardDto> cards)
    {
        String suit = cards.get(0).getSuit();
        for (CardDto card:cards)
        {
            if(!card.getSuit().equalsIgnoreCase(suit))
            {
                return false;
            }
        }
        return true;
    }

    public void setNextEvaluator(RankEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
    }
}
