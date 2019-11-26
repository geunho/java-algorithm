package dev.geunho;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

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

    /**
     * 위장
     * https://programmers.co.kr/learn/courses/30/lessons/42578
     * @param clothes
     * @return combination
     */
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

    /**
     * 베스트앨범
     * https://programmers.co.kr/learn/courses/30/lessons/42579
     * @param genres
     * @param plays
     * @return orderOfPlays
     */
    public static int[] 베스트앨범(String[] genres, int[] plays) {
        // <장르, 총 재생 횟수> 집계 테이블을 생성
        // <장르, 정렬된 곡 목록> 테이블 생성
        // 장르 길이만큼 순회 : N
        Hashtable<String, Integer> genreTotalCounts = new Hashtable<String, Integer>();
        Hashtable<String, List<Play>> playLists = new Hashtable<String, List<Play>>();
        int numberOfSongs = genres.length;
        
        for (int id = 0; id < numberOfSongs; id++) {
            String genre = genres[id];
            int play = plays[id];
            
            if (genreTotalCounts.containsKey(genre)) {
                int count = genreTotalCounts.get(genre);
                genreTotalCounts.put(genre, count + play);
            } else {
                genreTotalCounts.put(genre, play);
            }

            if (playLists.containsKey(genre)) {
                // 장르 순위에 따라 정렬된 곡 목록의 아이디 값을 연결 리스트에 추가
                List<Play> playList = playLists.get(genre);
                playList.add(new Play(id, genre, play));
            } else {
                List<Play> playList = new ArrayList<Play>();
                playList.add(new Play(id, genre, play));
                playLists.put(genre, playList);
            }
        }

        // 총 재생 횟수의 내림차순으로 정렬 (최대 99개로 성능에 영향 없음)
        Map<String, Integer> sortedGenreTotalCounts = genreTotalCounts
            .entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(
                toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                    LinkedHashMap::new));

        List<Integer> result = new ArrayList<Integer>();
        for (String genre : sortedGenreTotalCounts.keySet()) {
            List<Play> playList = playLists.get(genre);

            // 정렬된 목록의 상위 두 개만 추가
            List<Integer> topTwoIds = playList
                .stream()
                .sorted()
                .limit(2)
                .map(p -> p.getId())
                .collect(Collectors.toList());
            result.addAll(topTwoIds);
        }

        // 배열로 출력
        int[] answer = result.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}

class Play implements Comparable<Play> {
    private int id;
    private int numberOfPlay;

    Play(int id, String genre, int numberOfPlay) {
        this.id = id;
        this.numberOfPlay = numberOfPlay;
    }

    public int getId() {
        return this.id;
    }

    public int getNumberOfPlay() {
        return this.numberOfPlay;
    }

    @Override
    public int compareTo(Play o) {
        if (this.numberOfPlay == o.numberOfPlay) {
            return this.id - o.id;
        }
        return o.numberOfPlay - this.numberOfPlay;
    }
}