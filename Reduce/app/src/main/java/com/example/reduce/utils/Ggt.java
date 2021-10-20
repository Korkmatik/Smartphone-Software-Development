package com.example.reduce.utils;

public class Ggt {

    public static int calculate(int zaehler, int nenner) {
        int ggt = 1;

        if (zaehler * nenner != 0) {
            int rest;
            ggt = Math.abs(zaehler);
            int divisor = Math.abs(nenner);
            do {
                rest = ggt % divisor;
                ggt = divisor;
                divisor = rest;
            } while (rest > 0);
        }

        return ggt;
    }
}
