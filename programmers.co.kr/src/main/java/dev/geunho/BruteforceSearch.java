package dev.geunho;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TODO: 아직 해결하지 못한 문제
public class BruteforceSearch {
    /**
     * 모의고사 https://programmers.co.kr/learn/courses/30/lessons/42840
     * 
     * @param answers
     * @return
     */
    public static int[] 모의고사(int[] answers) {
        int[][] strategies = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }, };

        int[] counts = new int[strategies.length];

        // 각 학생들의 답안을 순회하면서 정답 개수를 계산해서 배열에 저장한다.
        // 학생 수 * N = 3N
        for (int i = 0; i < strategies.length; i++) {
            int[] strategy = strategies[i];
            counts[i] = countCorrects(strategy, answers);
        }

        List<Integer> result = new ArrayList<Integer>();
        int max = -1;

        // 정답 수가 가장 큰 학생의 번호를 결과 리스트에 저장한다.
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            if (count > max) {
                result.clear();
                result.add(i + 1);
                max = count;
            } else if (count == max) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static int countCorrects(int[] strategy, int[] answers) {
        int correctsCount = 0;

        // 답안 전략의 인덱스는 정답 인덱스 % 전략개수
        // 일치하는 경우 카운트를 증가하고 반환한다.
        // N
        for (int i = 0; i < answers.length; i++) {
            int answerIndex = i % strategy.length;
            int picked = strategy[answerIndex];
            if (picked == answers[i])
                correctsCount++;
        }

        return correctsCount;
    }

    /**
     * 소수 찾기 https://programmers.co.kr/learn/courses/30/lessons/42839
     * 
     * @param numbers
     * @return
     */
    public static int 소수찾기(String numbers) {
        // numbers를 순회하면서 모든 수의 조합을 Set에 입력한다.
        Set<Integer> numberSet = new HashSet<Integer>();
        // 1자리 부터 numbers.length 자리 까지.
        // length * N!
        //TODO: 모든 경우의 수를 구해야 함
        for (int comb = 1; comb < numbers.length(); comb++) {
            
        }

        int count = 0;
        // Set을 순회하면서 소수 여부를 판별한다.
        for (int number : numberSet) {
            // 소수인 경우 카운팅한다.
            if (isPrimeNumber(number))
                count++;
        }

        return count;
    }

    public static boolean isPrimeNumber(int number) {
        if (number < 2)
            return false;
        if (number == 2)
            return true;

        int maxDivider = (int) Math.ceil(Math.sqrt(number));
        for (int divider = 2; divider <= maxDivider; divider++) {
            if (number % divider == 0)
                return false;
        }

        return true;
    }
}