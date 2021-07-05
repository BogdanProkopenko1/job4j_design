package ru.job4j.srp;

import java.util.Random;
import java.util.regex.Pattern;

public class PassGenerator {

    private String generateString(int length) {
        Random random = new Random();
        char[] characters = new char[] {
                'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h',
                'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', '1', '2', '3', '4', '5', '6',
                '7', '8', '9', '0', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S',
                'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'
        };
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters[random.nextInt(characters.length)]);
        }
        return String.valueOf(result);
    }

    private String generateNumber(int length) {
        Random random = new Random();
        String result = "";
        while (result.length() != length) {
            result = String.valueOf(Math.abs(random.nextInt()));
        }
        return result;
    }

    private boolean check(String string) {
        Pattern pattern = Pattern.compile("[\\d\\w].");
        return pattern.matcher(string).find();
    }
}
