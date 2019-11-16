package dev.geunho;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class WindowQueueTest {
    @Test
    public void 큐_크기는_maxSize를_넘을_수_없다() {
        long MaxSize = 3;
        WindowQueue Q = new WindowQueue(MaxSize);

        Q.add(1);
        Q.add(1);
        Q.add(3);
        Q.add(1);

        assertEquals(MaxSize, Q.size());
    }

    @Test
    public void Max_Test_1() {
        long MaxSize = 3;
        WindowQueue Q = new WindowQueue(MaxSize);

        Q.add(1);
        Q.add(1);
        Q.add(3);
        Q.add(1);

        assertEquals(3, Q.max());
    }

    @Test
    public void Max_Test_2() {
        long MaxSize = 3;
        WindowQueue Q = new WindowQueue(MaxSize);

        Q.add(1);
        Q.add(1);
        Q.add(3);
        Q.add(4);

        assertEquals(4, Q.max());
    }

}