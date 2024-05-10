package com.amaap.pokerbesthandextension;

import com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidCardCodeException;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidHandSizeException;
import com.amaap.pokerbesthandextension.service.CardService;
import com.amaap.pokerbesthandextension.service.GameService;
import com.amaap.pokerbesthandextension.service.HandService;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.List;

import static com.amaap.pokerbesthandextension.domain.model.valueobject.HandRank.HIGHCARD;

public class Main {
    public static void main(String[] args) throws DuplicateCardException, InvalidCardCodeException, InvalidHandSizeException, HandNotFoundException {
        Injector injector = Guice.createInjector(new AppModule());
        CardService cardService = injector.getInstance(CardService.class);
        HandService handService = injector.getInstance(HandService.class);
        GameService gameService = injector.getInstance(GameService.class);

        cardService.create("S2");
        cardService.create("D5");
        cardService.create("C7");
        cardService.create("ST");
        cardService.create("HA");
        CardDto card1 = cardService.get("S2");
        CardDto card2 = cardService.get("D5");
        CardDto card3 = cardService.get("C7");
        CardDto card4 = cardService.get("ST");
        CardDto card5 = cardService.get("HA");
        List<CardDto> cards = List.of(card1, card2, card3, card4, card5);

        Hand hand = handService.create(cards);
        HandRank rank = gameService.checkRankFor(hand);
        if (rank == HIGHCARD) {
            String highCard = gameService.getHighCard(hand);
            System.out.println("The rank of hand is HIGHCARD and high card is " + highCard);
        } else {
            System.out.println("The rank of hand is "+ rank);
        }
    }
}
