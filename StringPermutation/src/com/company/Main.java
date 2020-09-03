package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPermutation("abab", "baba"));
        System.out.println(isPermutation("abab", "abc"));
        System.out.println(isPermutation("lds", "loodos"));
    }

    public static boolean isPermutation(String str1, String str2) {
        if (isStringAreEmpty(str1, str2)) {
            return false;
        }
        else {
            String longerString = str1.length() > str2.length() ? str1 : str2;
            String shorterString = str1.length() <= str2.length() ? str1 : str2;

            HashMap<Character, Integer> longerStringHashMap = prepareHashMap(longerString);
            HashMap<Character, Integer> shorterStringHashMap = prepareHashMap(shorterString);

            for (Map.Entry stringEntry : shorterStringHashMap.entrySet()) {
                if (longerStringHashMap.containsKey((stringEntry.getKey()))) {
                    if ((Integer) stringEntry.getValue() > longerStringHashMap.get(stringEntry.getKey())) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean isStringAreEmpty(String str1, String str2) {
        return str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0;
    }

    private static HashMap<Character, Integer> prepareHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ch1 = s.toCharArray();
        Arrays.sort(ch1);
        for (char c : ch1) {
            map.merge(c, 1, Integer::sum);
        }
        return map;
    }
}
