package dev.geunho;

import java.util.*;
// import java.util.stream.Collectors;

// import static java.util.stream.Collectors.*;

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
        StringBuilder answer = new StringBuilder();

        // 최대 자릿수를 찾고 -> N

        // 자릿수에 대한 기댓값 (예. 자릿수가 3이라면: 3-> 333, 34 -> 344) 반환하는 메서드로 정렬 -> N

        // 정렬된 배열을 문자열로 연결해서 출력 -> N
        // O(3N) -> O(N) 가능

        return answer.toString();
    }
}