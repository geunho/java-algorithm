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
        int[] numbers = { 40, 403 };
        // prefix인 경우 prefix되는 항목이 우선 나와야 한다.
        String expected = "40403";

        String result = Sort.가장_큰_수(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void 가장_큰_수_test_case_5() {
        int[] numbers = { 40, 40305 };
        // prefix인 경우 prefix되는 항목이 우선 나와야 한다.
        String expected = "4040305";

        String result = Sort.가장_큰_수(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void H_Index_test_case_1() {
        //입력값 〉	[3, 0, 6, 1, 5]
        //기댓값 〉	3
        int[] citations = { 3, 0, 6, 1, 5 };

        int result = Sort.H_Index(citations);

        assertEquals(3, result);
    }

    @Test
    public void H_Index_test_case_2() {
        //입력값 〉	[3, 10, 8, 4, 5]
        //기댓값 〉	4
        int[] citations = { 3, 10, 8, 4, 5 };

        int result = Sort.H_Index(citations);

        assertEquals(4, result);
    }

    @Test
    public void H_Index_test_case_3() {
        //입력값 〉	[3, 8, 25, 3, 5]
        //기댓값 〉	3
        int[] citations = { 3, 8, 25, 3, 5 };

        int result = Sort.H_Index(citations);

        assertEquals(3, result);
    }

    @Test
    public void H_Index_test_case_4() {
        int[] citations = { 20, 19, 18, 1 };

        int result = Sort.H_Index(citations);

        assertEquals(3, result);
    }

    @Test
    public void H_Index_test_case_5() {
        int[] citations = { 22, 42 };

        int result = Sort.H_Index(citations);

        assertEquals(2, result);
    }
}