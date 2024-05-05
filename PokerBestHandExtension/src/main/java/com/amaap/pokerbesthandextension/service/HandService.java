package com.amaap.pokerbesthandextension.service;

import com.amaap.pokerbesthandextension.repository.HandRepository;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;

import java.util.List;

public class HandService {
    HandRepository handRepository;
    public HandService(HandRepository handRepository) {
        this.handRepository = handRepository;
    }

    public Hand create(List<CardDto> cards) {
        Hand hand = Hand.create(cards);
        return handRepository.add(hand);
    }
}