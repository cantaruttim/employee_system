package br.com.cantarutti.config.utils;

import java.time.LocalDate;

public class PassWordUtils {

    public static String defaultPassword(String registrationNumber) {
        if (registrationNumber == null) return null;

        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();

        String lastDigits = registrationNumber.substring(
                registrationNumber.length() - 4
        );

        return year + String.format("%02d", month) + lastDigits;
    }
}
