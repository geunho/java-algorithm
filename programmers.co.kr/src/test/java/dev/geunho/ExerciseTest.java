package dev.geunho;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ExerciseTest {
    @Test
    public void test1() {
        // 입력값 〉 [[1, 4], [3, 4], [3, 10]]
        // 기댓값 〉 [1, 10]
        int[][] v = { {1,4},{3,4},{3,10}};
        int[] expected = {1, 10};
        int[] result = Exercise.solution1(v);
        assertArrayEquals(expected, result);
    }

    @Test
    public void test2() {
        Exercise.solution2(5, 3);
    }

    
}