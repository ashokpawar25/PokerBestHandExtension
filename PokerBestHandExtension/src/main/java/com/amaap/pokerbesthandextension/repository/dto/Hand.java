package com.amaap.pokerbesthandextension.repository.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hand {
    private List<CardDto> cards;
    public Hand(List<CardDto> cards) {
        this.cards = cards;
    }

    public static Hand create(List<CardDto> cards) {
        return new Hand(cards);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return Objects.equals(cards, hand.cards);
    }
}
