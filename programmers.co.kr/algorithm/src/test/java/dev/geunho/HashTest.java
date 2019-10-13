package dev.geunho;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashTest {
    @Test
    public void 완주하지_못한_선수_test_case_1() {
        String[] participants = { "leo", "kiki", "eden" };
        String[] completion = { "eden", "kiki" };

        String result = Hash.완주하지_못한_선수(participants, completion);

        assertEquals("leo", result);
    }

    @Test
    public void 완주하지_못한_선수_test_case_2() {
        String[] participants = { "marina", "josipa", "nikola", "vinko", "filipa" };
        String[] completion = { "josipa", "filipa", "marina", "nikola" };

        String result = Hash.완주하지_못한_선수(participants, completion);

        assertEquals("vinko", result);
    }

    @Test
    public void 완주하지_못한_선수_test_case_3() {
        String[] participants = { "mislav", "stanko", "mislav", "ana" };
        String[] completion = { "stanko", "ana", "mislav" };

        String result = Hash.완주하지_못한_선수(participants, completion);

        assertEquals("mislav", result);
    }
}