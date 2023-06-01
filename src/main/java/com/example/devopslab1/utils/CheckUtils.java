package com.example.devopslab1.utils;

import java.util.function.Predicate;

public class CheckUtils {
    public static boolean charIsRussian (char ch) {
        ch = Character.toLowerCase(ch);
        return ('а' <= ch && ch <= 'я') || ch == 'ё';
    }

    public static boolean anyInStrNot(String s, Predicate<Character> cond) {
        for (int i = 0; i < s.length(); i++) {
            if (!cond.test(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static String capitalize(String s) {
        return getInitial(s) + s.substring(1).toLowerCase();
    }

    public static char getInitial(String s) {
        return Character.toUpperCase(s.charAt(0));
    }

}
