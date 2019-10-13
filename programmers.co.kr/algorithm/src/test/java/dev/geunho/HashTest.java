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

    @Test
    public void 전화번호_목록_test_case_1() {
        String[] phone_book = { "119", "97674223", "1195524421" };
        
        boolean result = Hash.전화번호_목록(phone_book);

        assertEquals(false, result);
    }

    @Test
    public void 전화번호_목록_test_case_2() {
        String[] phone_book = { "123", "456", "789" };
        
        boolean result = Hash.전화번호_목록(phone_book);

        assertEquals(true, result);
    }

    @Test
    public void 전화번호_목록_test_case_3() {
        String[] phone_book = { "12", "123", "1235", "567", "88" };
        
        boolean result = Hash.전화번호_목록(phone_book);

        assertEquals(false, result);
    }

    @Test
    public void 위장_test_case_1() {        
        String[][] clothes = { {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        int result = Hash.위장(clothes);

        assertEquals(5, result);
    }

    @Test
    public void 위장_test_case_2() {
        String[][] clothes = { {"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        int result = Hash.위장(clothes);

        assertEquals(3, result);
    }
}