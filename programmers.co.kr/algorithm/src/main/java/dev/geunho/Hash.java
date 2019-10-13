package dev.geunho;

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
}