package com.PagueloFacil.ChallengePagueloFacil.utils;

import java.util.ArrayList;
import java.util.List;

public class utils {

    private static List<Integer> numberAccounts = new ArrayList<>();

    public static int randomNumber(int min, int max) {
            int number;
            do {
                number = (int) (Math.random() * (max - min) + min);

            } while (numberAccounts.contains(number));

            numberAccounts.add(number);
            return number;
    }
}
