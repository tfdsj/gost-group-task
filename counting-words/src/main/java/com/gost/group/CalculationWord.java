package com.gost.group;

import java.util.Map;

public interface CalculationWord {
    Map<String, Integer> countingWords(String text);
    Map<String, Integer > countingWordsAndSortByCount(String text);
    String[] splitStringForTokens(String text);
}
