package dev.geunho;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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

    @Test
    public void 프린터_test_case_1() {
        int[] priorities = { 2, 1, 3, 2 };
        int location = 2;

        int result = StackAndQueue.프린터(priorities, location);

        assertEquals(1, result);
    }

    @Test
    public void 프린터_test_case_2() {
        int[] priorities = { 1, 1, 9, 1, 1, 1 };
        int location = 0;

        int result = StackAndQueue.프린터(priorities, location);

        assertEquals(5, result);
    }
}
