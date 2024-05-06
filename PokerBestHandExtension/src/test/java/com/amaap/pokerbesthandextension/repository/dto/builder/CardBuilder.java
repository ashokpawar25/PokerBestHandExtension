package com.amaap.pokerbesthandextension.repository.dto.builder;

import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;

import java.util.List;

public class CardBuilder {

    public static List<CardDto> getFiveCards() throws InvalidCardCodeException {
        CardDto card1 = CardDto.create("H4");
        CardDto card2 = CardDto.create("C7");
        CardDto card3 = CardDto.create("CT");
        CardDto card4 = CardDto.create("SJ");
        CardDto card5 = CardDto.create("DK");
        return List.of(card1,card2,card3,card4,card5);
    }

    public static List<CardDto> getFourCards() throws InvalidCardCodeException {
        CardDto card1 = CardDto.create("H4");
        CardDto card2 = CardDto.create("C7");
        CardDto card3 = CardDto.create("CT");
        CardDto card4 = CardDto.create("SJ");
        return List.of(card1,card2,card3,card4);
    }

    public static List<CardDto> getCardsForFlushRank() throws InvalidCardCodeException {
        CardDto card1 = CardDto.create("C4");
        CardDto card2 = CardDto.create("C7");
        CardDto card3 = CardDto.create("CT");
        CardDto card4 = CardDto.create("CJ");
        CardDto card5 = CardDto.create("CK");
        return List.of(card1,card2,card3,card4,card5);
    }

    public static List<CardDto> getCardsForPairRank() throws InvalidCardCodeException {
        CardDto card1 = CardDto.create("H4");
        CardDto card2 = CardDto.create("C7");
        CardDto card3 = CardDto.create("CT");
        CardDto card4 = CardDto.create("SJ");
        CardDto card5 = CardDto.create("D4");
        return List.of(card1,card2,card3,card4,card5);
    }

    public static List<CardDto> getCardsForThreeOfAKindRank() throws InvalidCardCodeException {
        CardDto card1 = CardDto.create("H4");
        CardDto card2 = CardDto.create("C7");
        CardDto card3 = CardDto.create("C4");
        CardDto card4 = CardDto.create("SJ");
        CardDto card5 = CardDto.create("D4");
        return List.of(card1,card2,card3,card4,card5);
    }

    public static List<CardDto> getCardsForFourOfAKindRank() throws InvalidCardCodeException {
        CardDto card1 = CardDto.create("H4");
        CardDto card2 = CardDto.create("C4");
        CardDto card3 = CardDto.create("C4");
        CardDto card4 = CardDto.create("SJ");
        CardDto card5 = CardDto.create("D4");
        return List.of(card1,card2,card3,card4,card5);
    }

    public static List<CardDto> getCardsForStraightRank() throws InvalidCardCodeException {
        CardDto card1 = CardDto.create("HT");
        CardDto card2 = CardDto.create("CJ");
        CardDto card3 = CardDto.create("C8");
        CardDto card4 = CardDto.create("S7");
        CardDto card5 = CardDto.create("D9");
        return List.of(card1,card2,card3,card4,card5);
    }
    public static List<CardDto> getCardsForStraightFlushRank() throws InvalidCardCodeException {
        CardDto card1 = CardDto.create("CT");
        CardDto card2 = CardDto.create("CJ");
        CardDto card3 = CardDto.create("CK");
        CardDto card4 = CardDto.create("CQ");
        CardDto card5 = CardDto.create("C9");
        return List.of(card1,card2,card3,card4,card5);
    }

}
