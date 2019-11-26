package dev.geunho;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxWindowTest {
    @Test
    public void 큐의_크기는_최대_개수를_넘어서는_안된다() {
        long maxSize = 3L;
        WindowQueue queue = new WindowQueue(maxSize);

        queue.add(2321L);
        queue.add(321L);
        queue.add(874L);
        queue.add(1000L);

        assertEquals(maxSize, queue.size());
    }

    @Test
    public void 입력된_순서와_무관하게_윈도우_크기_내에서_가장_큰_값을_반환한다() {
        long maxSize = 3L;
        WindowQueue queue = new WindowQueue(maxSize);

        queue.add(2321L);
        queue.add(874L);
        queue.add(232319923L);
        queue.add(1000L);
        queue.add(2321L);
     
        assertEquals(232319923L, queue.max());
    }
}
