package com.amaap.pokerbesthandextension.repository.dto.validator;

public class CardValidator {
    public static boolean isValidCode(String code) {
        if (isNullCode(code) && isEmptyCode(code) && isInvalidCode(code))
        {
            return false;
        }
        return true;
    }

    private static boolean isInvalidCode(String code)
    {
        return !code.matches("^[CHSD][ATKQJ2-9]$");
    }

    private static boolean isEmptyCode(String code)
    {
        return code.isEmpty();
    }

    private static boolean isNullCode(String code)
    {
        return code == null;
    }
}
