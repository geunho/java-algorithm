package dev.geunho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class myCode2 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstInputs = br.readLine();
        int[] sticks = Arrays.stream(firstInputs.split(" ")).mapToInt(Integer::parseInt).toArray();
        int targetLength = Integer.valueOf(br.readLine());

        int[] result = findPairs(sticks, targetLength);

        // result to stdout
        if (result == null) {
            System.out.println(-1);
        } else {
            System.out.printf("%d %d\n", result[0], result[1]);
        }
    }

    // O(N!)
    public static int[] findPairs(int[] sticks, int targetLength) {
        Map<Integer, Integer> matchedPairs = new HashMap<>();
        // 쌍이 되는 모든 경우의 수를 찾고
        for (int i = 0; i < sticks.length - 1; i++) {
            int first = sticks[i];

            for (int j = i + 1; j < sticks.length; j++) {
                int second = sticks[j];
                // 길이 합이 맞는 경우 쌍을 저장
                // 단, 이때 첫 번째 값은 두번 째 값보다 작아야 한다.
                if (first + second == targetLength) {
                    if (first <= second)
                        matchedPairs.put(first, second);
                    else
                        matchedPairs.put(second, first);
                }
            }
        }

        if (matchedPairs.isEmpty())
            return null;

        // 쌍의 목록 중 첫 번째 값이 가장 작은 쌍을 반환
        int minKey = matchedPairs.keySet().stream().reduce(Math::min).get();
        int[] result = { minKey, matchedPairs.get(minKey) };
        return result;
    }
}