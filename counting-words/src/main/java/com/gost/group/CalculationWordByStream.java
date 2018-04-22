package com.gost.group;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.reducing;

class CalculationWordByStream implements CalculationWord {

    @Override
    public Map<String, Integer> countingWordsAndSortByCount(String text) {
        return sortingByCount(countingWords(text));
    }

    @Override
    public Map<String, Integer> countingWords(String text) {
        return Arrays.stream(splitStringForTokens(text)).parallel().map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(), reducing(0, e -> 1, Integer::sum)));
    }
    //([^\p{L}|^\s])|(\s(у|(i)в|и|из|за|ту)\s)
    /**
     * удаляем все знаки припенания, цифры. Такие слова как объектно-ориентированный - это 2 слова
     */
    //String regex = "\\p{L}+\\-\\p{L}+){3,}|\\p{L}{3,}";
    @Override
    public String[] splitStringForTokens(String text) {
       // String regex = "([^\\p{L}])";

        String regex = "([^\\p{L}])";

        return text.replaceAll(regex, " ").split("\\s+");
    }

    private Map<String, Integer> sortingByCount(Map<String, Integer> mapWords) {
        Map<String, Integer> sortedMapByValue = new LinkedHashMap<>();
        mapWords.entrySet().parallelStream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEachOrdered(e -> sortedMapByValue.put(e.getKey(), e.getValue()));
        return sortedMapByValue;
    }
}
