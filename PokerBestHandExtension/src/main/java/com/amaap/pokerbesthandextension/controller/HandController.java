package com.amaap.pokerbesthandextension.controller;

import com.amaap.pokerbesthandextension.controller.dto.Response;
import com.amaap.pokerbesthandextension.repository.dto.CardDto;
import com.amaap.pokerbesthandextension.repository.dto.Hand;
import com.amaap.pokerbesthandextension.service.HandService;

import java.util.List;

public class HandController {
    HandService handService;
    public HandController(HandService handService) {
        this.handService = handService;
    }

    public Hand create(List<CardDto> cards) {
        return handService.create(cards);
    }

}
