package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = -1;
        for (int i = 0; i < left.length(); i++) {
            char leftChar = left.charAt(i);
            char rightChar = right.charAt(i);
            result = Character.compare(leftChar, rightChar);
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}