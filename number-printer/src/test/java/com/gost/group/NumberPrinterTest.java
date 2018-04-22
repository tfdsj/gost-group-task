package com.gost.group;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class NumberPrinterTest {
    private NumberPrinter numberPrinter;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before NumberPrinterTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After NumberPrinterTest.class");
    }

    @Before
    public void initTest() {
        numberPrinter = new NumberPrinterImpl();
    }

    @After
    public void afterTest() {
        numberPrinter = null;
    }

    @Test
    public void testCorrectPrint() throws Exception {
        String builder = "1\n" +
                Constant.ReplaysNumberToText.TWO +
                "\n" +
                "3\n" +
                Constant.ReplaysNumberToText.TWO +
                "\n" +
                "5\n" +
                Constant.ReplaysNumberToText.TWO +
                "\n" +
                Constant.ReplaysNumberToText.SEVEN +
                "\n" +
                Constant.ReplaysNumberToText.TWO +
                "\n" +
                "9\n" +
                Constant.ReplaysNumberToText.TWO +
                "\n" +
                "11\n" +
                Constant.ReplaysNumberToText.TWO +
                "\n" +
                "13\n" +
                Constant.ReplaysNumberToText.TWO +
                Constant.ReplaysNumberToText.SEVEN +
                "\n";

        String result = numberPrinter.print(1, 14, numberPrinter.defaultMapReplaysNumberToString());
        assertEquals(builder, result);
    }

    @Test
    public void testCorrectPrintNotReplays() throws Exception {
        String builder = "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "8\n" +
                "9\n" +
                "10\n";

        String result = numberPrinter.print(1, 10, null);
        assertEquals(builder, result);
    }

    @Test
    public void testWrongIndex() throws Exception {
        String result = numberPrinter.print(-15, -25, null);
        assertEquals("", result);
    }
}
