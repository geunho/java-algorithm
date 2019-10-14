package dev.geunho;

import java.util.*;

public class Sort {
    /**
     * K번째수 https://programmers.co.kr/learn/courses/30/lessons/42748
     * 
     * @param array
     * @param commands
     * @return kList
     */
    public static int[] K번째수(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // commands 순회하면서 sub array 잘라내기
        for (int index = 0; index < commands.length; index++) {
            int[] command = commands[index];
            int i = command[0] - 1; // inclusive start index
            int j = command[1]; // exclusive end index
            int k = command[2] - 1; // 정렬 후 위치

            // 잘라낸 array 정렬하고 k번째 원소를 answer에 입력
            int[] subArray = Arrays.copyOfRange(array, i, j);
            Arrays.sort(subArray);

            answer[index] = subArray[k];
        }

        return answer;
    }

    /**
     * 가장 큰 수 https://programmers.co.kr/learn/courses/30/lessons/42746
     * 
     * @param numbers
     * @return biggestNumber
     */
    public static String 가장_큰_수(int[] numbers) {    
        Object[] numbersList = Arrays.stream(numbers).boxed().toArray();
        // 내림차순 정렬
        Arrays.sort(numbersList, (Object n1, Object n2) -> {
                String n1n2 = n1.toString() + n2.toString();
                String n2n1 = n2.toString() + n1.toString();
                return Integer.valueOf(n2n1) - Integer.valueOf(n1n2);
            }
        );

        // 가장 큰 값이 0이면 결과는 "0"
        if ((int)numbersList[0] == 0) return "0";

        // 정렬된 배열을 문자열로 연결해서 출력
        StringBuilder result = new StringBuilder();
        for (Object number : numbersList) result.append(number);
        
        return result.toString();
    }

    /**
     * H-Index https://programmers.co.kr/learn/courses/30/lessons/42747
     * 
     * @param citations
     * @return h-index
     */
    public static int H_Index(int[] citations) {
        List<Integer> citationsList = new ArrayList<Integer>(citations.length);
        for (int citation : citations) citationsList.add(citation);
        
        // 내림차순 정렬 후
        Collections.sort(citationsList, Comparator.reverseOrder());

        // 순회하면서 index와 수가 일치하거나 index가 큰 경우 큰 값을 반환
        for (int index = 0; index < citations.length; index++) {
            int citation = citationsList.get(index);
            if (citation <= index) return index;
        }

        return citations.length;
    }
}