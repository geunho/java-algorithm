package dev.geunho;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SortTest {
    @Test
    public void K번째수_test_case_1() {
        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

        int[] result = Sort.K번째수(array, commands);
        int[] expected = { 5, 6, 3 };
        assertArrayEquals(expected, result);
    }

    @Test
    public void 가장_큰_수_test_case_1() {
        int[] numbers = { 3, 30, 34, 5, 9 };

        String expected = "9534330";

        String result = Sort.가장_큰_수(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void 가장_큰_수_test_case_2() {
        int[] numbers = { 3, 30, 32, 5, 9 };

        String expected = "9533230";

        String result = Sort.가장_큰_수(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void 가장_큰_수_test_case_3() {
        int[] numbers = { 998, 9, 999 };

        String expected = "9999998";

        String result = Sort.가장_큰_수(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void 가장_큰_수_test_case_4() {
        int[] numbers = { 0, 0, 0, 0 };

        String expected = "0";

        String result = Sort.가장_큰_수(numbers);

        assertEquals(expected, result);
    }
}