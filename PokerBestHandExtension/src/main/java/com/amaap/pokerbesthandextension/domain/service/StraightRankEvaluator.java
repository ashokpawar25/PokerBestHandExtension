package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StraightRankEvaluator implements RankEvaluator {
    private RankEvaluator nextEvaluator;

    @Override
    public HandRank getRank(List<CardDto> cards) {
        return isStraightRank(cards) ? HandRank.STRAIGHT : (nextEvaluator != null ? nextEvaluator.getRank(cards) : null);
    }

    private boolean isStraightRank(List<CardDto> cardDtos) {
        List<CardDto> cards = new ArrayList<>(cardDtos);
        String order = "A23456789TJQK";
        cards.sort(new Comparator<CardDto>() {
            @Override
            public int compare(CardDto card1, CardDto card2) {
                int index1 = order.indexOf(card1.getRank());
                int index2 = order.indexOf(card2.getRank());
                return Integer.compare(index1, index2);
            }
        });
        for (int i = 0; i < cards.size() - 1; i++) {
            int currentIndex = order.indexOf(cards.get(i).getRank());
            int nextIndex = order.indexOf(cards.get(i + 1).getRank());
            if (nextIndex - currentIndex != 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public RankEvaluator setNextEvaluator(RankEvaluator nextEvaluator) {
        this.nextEvaluator = nextEvaluator;
        return this;
    }
}
