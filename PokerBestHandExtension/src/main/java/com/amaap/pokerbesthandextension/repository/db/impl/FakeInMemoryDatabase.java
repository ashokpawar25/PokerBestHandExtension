package com.amaap.pokerbesthandextension.repository.db.impl;

import com.amaap.pokerbesthandextension.repository.db.InMemoryDatabase;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeInMemoryDatabase implements InMemoryDatabase {
    List<CardDto> cards = new ArrayList<>();
    @Override
    public CardDto insertIntoCardTable(CardDto cardDto) throws DuplicateCardException {
        Optional<CardDto> existingCard = cards.stream().filter(card -> card.getCode().equalsIgnoreCase(cardDto.getCode())).findFirst();
        if(existingCard.isPresent()) {
            throw new DuplicateCardException("Card:"+cardDto.getCode()+" is already present in database");
        }
        cards.add(cardDto);
        return cardDto;
    }

    @Override
    public CardDto findCard(String code) {
        return cards.stream().filter(card -> card.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
    }
}
