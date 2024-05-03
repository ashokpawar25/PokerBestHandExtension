package com.amaap.pokerbesthandextension.repository.db;

import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

public interface InMemoryDatabase {
    CardDto insertIntoCardTable(CardDto card) throws DuplicateCardException;

    CardDto findCard(String code);
}
