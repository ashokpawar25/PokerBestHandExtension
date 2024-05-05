package com.amaap.pokerbesthandextension.repository;

import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;

import java.util.List;

public interface HandRepository {
    Hand add(Hand hand);

    List<CardDto> getCardsForHand(Hand hand) throws HandNotFoundException;
}
