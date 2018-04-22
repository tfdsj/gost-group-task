package com.gost.group;
import java.util.Map;


public class NumberPrinterImpl implements NumberPrinter {

    @Override
    public String print(int indexStartPrint, int indexEndPrint, Map<Integer, String> mapReplaysNumberToString) {
        StringBuilder  buffer = new StringBuilder ();
        for(int iterator = indexStartPrint; iterator <= indexEndPrint; iterator++) {
            boolean isReplace = false;
            if(mapReplaysNumberToString != null && mapReplaysNumberToString.size()>0) {
                for(Map.Entry<Integer, String> entry : mapReplaysNumberToString.entrySet()) {
                    if(iterator % entry.getKey() == 0) {
                        buffer.append(entry.getValue());
                        isReplace = true;
                    }
                }
            }
            if(!isReplace) buffer.append(iterator);
            buffer.append("\n");
        }
        return buffer.toString();
    }

    @Override
    public String printReplaysTwoSevenNumber() {
        return print(1, 100, defaultMapReplaysNumberToString());
    }
}
