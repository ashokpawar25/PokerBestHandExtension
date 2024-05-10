package com.amaap.pokerbesthandextension.repository.dto.validator;

import org.junit.jupiter.api.Test;

import static com.amaap.pokerbesthandextension.repository.dto.validator.CardValidator.*;
import static org.junit.jupiter.api.Assertions.*;

class CardValidatorTest {

    @Test
    void shouldBeAbleToValidateValidCardCodes()
    {
        assertTrue(isValidCode("D5"));
        assertTrue(isValidCode("ST"));
        assertTrue(isValidCode("DA"));
        assertTrue(isValidCode("HJ"));
        assertTrue(isValidCode("CK"));
    }

    @Test
    void shouldBeAbleToValidateInvalidCardCode()
    {
        assertFalse(isValidCode(null));
        assertFalse(isValidCode(""));
        assertFalse(isValidCode("H Q"));
        assertFalse(isValidCode("C  J"));
        assertFalse(isValidCode("   S7"));
        assertFalse(isValidCode("D2     "));
        assertFalse(isValidCode("@6"));
        assertFalse(isValidCode("V8"));
        assertFalse(isValidCode("CN"));
        assertFalse(isValidCode("CODE"));
        assertFalse(isValidCode("H5 S9"));
        assertFalse(isValidCode("   S3 "));
        assertFalse(isValidCode(" C 5 "));
    }

    @Test
    void shouldBeAbleToValidateEmptyCardCode()
    {
        assertTrue(isEmptyCode(""));
        assertFalse(isEmptyCode("H5"));
    }

    @Test
    void shouldBeAbleToValidateNullCardCode()
    {
        assertTrue(isNullCode(null));
        assertFalse(isNullCode(""));
    }

    @Test
    void shouldBeAbleToCreateInstanceOfClass()
    {
        // arrange & act
        CardValidator cardValidator = new CardValidator();

        // assert
        assertNotNull(cardValidator);
    }
}