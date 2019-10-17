package dev.geunho;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class StackAndQueueTest {
    @Test
    public void 기능개발_test_case_1() {
        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };

        int[] expected = { 2, 1 };

        int[] result = StackAndQueue.기능개발(progresses, speeds);

        assertArrayEquals(expected, result);
    }
}
