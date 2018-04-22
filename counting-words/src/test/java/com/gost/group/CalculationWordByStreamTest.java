package com.gost.group;

import org.hamcrest.collection.IsMapContaining;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculationWordByStreamTest {

    private CalculationWord calculationWord;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before CountWordByStreamTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After CountWordByStreamTest.class");
    }

    @Before
    public void initTest() {
        calculationWord = new CalculationWordByStream();
    }

    @After
    public void afterTest() {
        calculationWord = null;
    }

    @Test
    public void testCalculatedWordCount() throws Exception {
        String text = "Java[прим. 1] — сильно типизированный объектно-ориентированный язык программирования, разработанный компанией Sun Microsystems. JAva, JAVA,  ";
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("java", 3);
        testMap.put("прим", 1);
        testMap.put("сильно", 1);
        testMap.put("типизированный", 1);
        testMap.put("объектно", 1);
        testMap.put("ориентированный", 1);
        testMap.put("язык", 1);
        testMap.put("программирования", 1);
        testMap.put("разработанный", 1);
        testMap.put("компанией", 1);
        testMap.put("Sun", 1);
        testMap.put("Microsystems", 1);



        Map<String, Integer> countingWordsMap = calculationWord.countingWords(text);
        assertThat(countingWordsMap.size(), is(12));
        assertThat(countingWordsMap, IsMapContaining.hasEntry("java", 3));
        assertThat(countingWordsMap, IsMapContaining.hasEntry("прим", 1));
        assertThat(countingWordsMap, IsMapContaining.hasEntry("сильно", 1));
        assertThat(countingWordsMap, IsMapContaining.hasEntry("типизированный", 1));
        assertThat(countingWordsMap, IsMapContaining.hasEntry("объектно", 1));
        assertThat(countingWordsMap, IsMapContaining.hasEntry("ориентированный", 1));
        assertThat(countingWordsMap, not(IsMapContaining.hasKey(".")));
        assertThat(countingWordsMap, not(IsMapContaining.hasKey("1")));
        assertThat(countingWordsMap, not(IsMapContaining.hasKey("—")));
        assertThat(countingWordsMap, not(IsMapContaining.hasKey(" ")));
    }
}
