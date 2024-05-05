package com.amaap.pokerbesthandextension.repository.dto.builder;

import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.List;

public class CardBuilder {

    public static List<CardDto> getFiveCards() {
        CardDto card1 = new CardDto("H4");
        CardDto card2 = new CardDto("C7");
        CardDto card3 = new CardDto("CT");
        CardDto card4 = new CardDto("SJ");
        CardDto card5 = new CardDto("DK");
        return List.of(card1,card2,card3,card4,card5);
    }

    public static List<CardDto> getFourCards() {
        CardDto card1 = new CardDto("H4");
        CardDto card2 = new CardDto("C7");
        CardDto card3 = new CardDto("CT");
        CardDto card4 = new CardDto("SJ");
        return List.of(card1,card2,card3,card4);
    }
}
