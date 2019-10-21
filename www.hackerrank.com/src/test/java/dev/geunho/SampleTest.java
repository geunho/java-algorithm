package dev.geunho;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SampleTest {

    @Test
    public void equivalentOrNot_test1() {
        assertEquals(true, Sample.equivalentOrNot("abbb", "accc"));
    }

    @Test
    public void equivalentOrNot_test2() {
        assertEquals(true, Sample.equivalentOrNot("aaa", "aab"));
    }

    @Test
    public void equivalentOrNot_test3() {
        assertEquals(false, Sample.equivalentOrNot("abcdefffff", "aabggggggg"));
    }

    @Test
    public void compress_test1() {
        List<Integer> asciiList = new ArrayList<>();
        asciiList.add(1);
        asciiList.add(2);
        asciiList.add(2);
        asciiList.add(3);
        asciiList.add(3);
        asciiList.add(3);
        asciiList.add(2);

        int[] expecteds = { 1, 2, 2, 2 };

        List<Integer> result = Sample.compress(asciiList, 3);
        int[] actuals = result.stream().mapToInt(i -> i).toArray();

        assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void compressWord_test1() {
        String expected = "a";
        String actual = Sample.compressWord("abbcccb", 3);
        assertEquals(expected, actual);
    }

    @Test
    public void compressWord_test2() {
        String expected = "abb";
        String actual = Sample.compressWord("abbbbcccb", 3);
        assertEquals(expected, actual);
    }
}