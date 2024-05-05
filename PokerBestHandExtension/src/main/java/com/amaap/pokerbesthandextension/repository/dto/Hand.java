package com.amaap.pokerbesthandextension.repository.dto;

import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidHandSizeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hand {
    private List<CardDto> cards;
    public Hand(List<CardDto> cards) {
        this.cards = cards;
    }

    public static Hand create(List<CardDto> cards) throws InvalidHandSizeException {
        if(cards.size() != 5) throw new InvalidHandSizeException("Invalid hand size "+cards.size());
        return new Hand(cards);
    }

    public List<CardDto> getCards() {
        return cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return Objects.equals(cards, hand.cards);
    }
}
