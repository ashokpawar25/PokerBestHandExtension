package com.amaap.pokerbesthandextension.repository.db;

import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;

public interface InMemoryDatabase {
    CardDto insertIntoCardTable(CardDto card) throws DuplicateCardException;

    CardDto findCard(String code);

    Hand insertIntoHandTable(Hand hand);
}
