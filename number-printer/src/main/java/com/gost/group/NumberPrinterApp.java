package com.gost.group;


public class NumberPrinterApp {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinterImpl();
        String text = numberPrinter.printReplaysTwoSevenNumber();
        System.out.println(text);
    }
}
