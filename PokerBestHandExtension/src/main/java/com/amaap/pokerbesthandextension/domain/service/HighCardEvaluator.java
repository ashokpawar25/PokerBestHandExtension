package com.amaap.pokerbesthandextension.domain.service;

import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.List;

public class HighCardEvaluator {
    public static String getHighCard(List<CardDto> cards) {
        String order = "23456789TJQKA";
        String highRank = null;
        for(CardDto card:cards)
        {
            if(highRank == null || order.indexOf(card.getRank()) > order.indexOf(highRank)){
                highRank = card.getRank();
            }
        }
        return "high-card-"+getRankName(highRank);
    }

    private static String getRankName(String rank) {
        return switch (rank.toUpperCase()) {
            case "A" -> "ace";
            case "K" -> "king";
            case "Q" -> "queen";
            case "J" -> "jack";
            case "T" -> "ten";
            case "9" -> "nine";
            case "8" -> "eight";
            case "7" -> "seven";
            case "6" -> "six";
            case "5" -> "five";
            case "4" -> "four";
            case "3" -> "three";
            case "2" -> "two";
            default -> "unknown";
        };
    }
}
