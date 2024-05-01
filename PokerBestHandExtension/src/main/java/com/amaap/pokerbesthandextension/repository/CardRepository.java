package com.amaap.pokerbesthandextension.repository;

import com.amaap.pokerbesthandextension.repository.db.impl.exception.DuplicateCardException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;

public interface CardRepository {
    CardDto add(CardDto card) throws DuplicateCardException;
}
