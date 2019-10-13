package dev.geunho;

import java.util.HashSet;
import java.util.Hashtable;

public class Hash {

    /**
     * 완주하지 못한 선수
     * https://programmers.co.kr/learn/courses/30/lessons/42576
     * @param participants
     * @param completion
     * @return imcomplete
     */
    public static String 완주하지_못한_선수(String[] participants, String[] completion) {
        String answer = "";
    
        // participant 길이가 1인 경우 그대로 반환 (한 명의 미완주 선수가 있으므로)
        if (participants.length == 1) {
            answer = participants[0];
            return answer;
        }
        
        // participant -> HashTable로 변환 : N
        Hashtable<String, Integer> participantTable = new Hashtable<String, Integer>();
        for (String participant : participants) {
            Integer count = participantTable.get(participant);
            if (count == null) {
                participantTable.put(participant, 1);
            } else {
                participantTable.put(participant, ++count);
            }            
        }
        
        // completion에 존재하는 항목은 카운트 감소 처리 : N
        for (String participant : completion) {
            Integer count = participantTable.get(participant);
            participantTable.put(participant, --count);
        }
        
        // participant 순회해서 table count가 양수인 항목 반환 : N
        // O(3N) -> O(N)
        for (String participant : participants) {
            Integer count = participantTable.get(participant);
            if (count > 0) {
                answer = participant;
                break;
            }
        }
        
        return answer;
    }

    /**
     * 전화번호 목록
     * https://programmers.co.kr/learn/courses/30/lessons/42577
     * @param phone_book
     * @return prefixExists
     */
    public static boolean 전화번호_목록(String[] phone_book) {
        // hash set 생성 후 phone_book 순차 조회 시작 : N
        HashSet<String> phoneBookSet = new HashSet<String>();
        for (String phoneNumber : phone_book) {
            // hash set 항목 중 phone_book의 하위 혹은 상위 항목이 되는 경우가 있다면 false 반환 : N
            for (String el : phoneBookSet) {
                if (phoneNumber.startsWith(el) || el.startsWith(phoneNumber)) return false;
            }
            // 없다면 hash set에 삽입
            phoneBookSet.add(phoneNumber);
        }

        // 모두 삽입되고 끝나면 true 반환
        return true;
    }

    public static int 위장(String[][] clothes) {
        int answer = 1;

        // clothes 배열을 순회해서 <종류, 갯수>인 해시맵을 생성한다. 
        Hashtable<String, Integer> counts = new Hashtable<String, Integer>();
        for (String[] piece : clothes) {
            String category = piece[1];
            if (counts.containsKey(category)) {
                int count = counts.get(category);
                counts.put(category, ++count);
            } else {
                counts.put(category, 1);
            }
        }
        
        // 갯수 + 1(입지 않는 경우)를 모두 곱한다.
        for (String category : counts.keySet()) {
            answer *= (counts.get(category) + 1);
        }

        // 1을(모두 입지 않은 경우) 뺀 후 반환한다.
        return --answer;
    }
}