package com.gost.group;

import java.util.HashMap;
import java.util.Map;

public interface NumberPrinter {
    String print(int indexStartPrint, int indexEndPrint, Map<Integer, String> mapChangeNumberToString);
    String printReplaysTwoSevenNumber();

    default Map<Integer, String> defaultMapReplaysNumberToString() {
        Map<Integer, String> mapReplaysNumberToString = new HashMap<Integer, String>();
        mapReplaysNumberToString.put(2, Constant.ReplaysNumberToText.TWO);
        mapReplaysNumberToString.put(7, Constant.ReplaysNumberToText.SEVEN);
        return mapReplaysNumberToString;
    }
}
