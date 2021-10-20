package com.example.reduce.utils;

import java.util.regex.Pattern;

public class CheckNumber {

    private static Pattern pattern = Pattern.compile("\\d+");

    public static boolean check(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
