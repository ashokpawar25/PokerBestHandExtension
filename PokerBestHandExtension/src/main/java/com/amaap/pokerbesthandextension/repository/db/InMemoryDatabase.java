package com.amaap.pokerbesthandextension.repository.db;

import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;

import java.util.List;

public interface InMemoryDatabase {
    CardDto insertIntoCardTable(CardDto card) throws DuplicateCardException;

    CardDto findCard(String code);

    Hand insertIntoHandTable(Hand hand);

    List<CardDto> getCardsForHand(Hand hand) throws HandNotFoundException;
}
