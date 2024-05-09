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
        assert highRank != null;
        return "high-card-"+getRankName(highRank);
    }

    private static String getRankName(String rank) {
        switch (rank.toUpperCase()) {
            case "A":
                return "ace";
            case "K":
                return "king";
            case "Q":
                return "queen";
            case "J":
                return "jack";
            case "T":
                return "ten";
            case "9":
                return "nine";
            case "8":
                return "eight";
            case "7":
                return "seven";
            case "6":
                return "six";
            case "5":
                return "five";
            case "4":
                return "four";
            case "3":
                return "three";
            case "2":
                return "two";
            default:
                return "unknown";
        }
    }
}
