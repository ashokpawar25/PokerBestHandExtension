package com.amaap.pokerbesthandextension.service;

import com.amaap.pokerbesthandextension.repository.HandRepository;
import com.amaap.pokerbesthandextension.repository.db.impl.exception.HandNotFoundException;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.repository.dto.exception.InvalidHandSizeException;

import java.util.List;

public class HandService {
    HandRepository handRepository;
    public HandService(HandRepository handRepository) {
        this.handRepository = handRepository;
    }

    public Hand create(List<CardDto> cards) throws InvalidHandSizeException {
        Hand hand = Hand.create(cards);
        return handRepository.add(hand);
    }

    public List<CardDto> getCardsForHand(Hand hand) throws HandNotFoundException {
        return handRepository.getCardsForHand(hand);
    }
}