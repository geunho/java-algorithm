package dev.geunho;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Level2Test {

    @Test
    public void problem1_test_case_1() {
        int[] A = { 1, 4, 2 };
        int[] B = { 5, 4, 4 };
        int result = Level2.problem1(A, B);

        assertEquals(29, result);
    }

    @Test
    public void problem1_test_case_2() {
        int[] A = { 1, 2 };
        int[] B = { 3, 4 };
        int result = Level2.problem1(A, B);

        assertEquals(10, result);
    }

    @Test
    public void problem2_test_case_2() {
        // 입력값 〉 4, [4, 10, 15], [20, 5, 10], 30
        // 기댓값 〉 2
        int stock = 4;
        int[] dates = { 4, 10, 15 };
        int[] supplies = { 20, 5, 10 };
        int k = 30;

        int result = Level2.problem2(stock, dates, supplies, k);

        assertEquals(2, result);
    }

}
