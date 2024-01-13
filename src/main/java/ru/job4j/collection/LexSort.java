package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftSplit = left.split("\\.", 2);
        String[] rightSplit = right.split("\\.", 2);
        int leftNumber = Integer.parseInt(leftSplit[0]);
        int rightNumber = Integer.parseInt(rightSplit[0]);
        return Integer.compare(leftNumber, rightNumber);
    }
}