package dev.geunho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level2 {
    public static int problem1(int[] A, int[] B) {
        int size = A.length;
        List<Pair> Alist = new ArrayList<Pair>();
        List<Pair> Blist = new ArrayList<Pair>();

        // 입력을 (값,인덱스) 튜플의 리스트로 변환
        for (int i = 0; i < size; i++) {
            Alist.add(new Pair(A[i], i));
            Blist.add(new Pair(B[i], i));
        }

        int sum = 0;
        // 입력 배열의 길이만큼 순회하면서
        for (int i = 0; i < size; i++) {
            Pair aMax = Alist.parallelStream().reduce(new Pair(0, 0), (p1, p2) -> {
                if (p1.value >= p2.value)
                    return p1;
                else
                    return p2;
            });
            Pair aMin = Alist.parallelStream().reduce(new Pair(Integer.MAX_VALUE, 0), (p1, p2) -> {
                if (p1.value < p2.value)
                    return p1;
                else
                    return p2;
            });
            Pair bMax = Blist.parallelStream().reduce(new Pair(0, 0), (p1, p2) -> {
                if (p1.value >= p2.value)
                    return p1;
                else
                    return p2;
            });
            Pair bMin = Blist.parallelStream().reduce(new Pair(Integer.MAX_VALUE, 0), (p1, p2) -> {
                if (p1.value < p2.value)
                    return p1;
                else
                    return p2;
            });

            // 서로의 가장 큰 값과 가장 작은 값을 곱한 수가 더 작은 값을 선택
            if (aMax.value * bMin.value <= aMin.value * bMax.value) {
                // 해당 인덱스 값은 삭제하고 계산한 값은 accum에 합한다.
                sum += aMax.value * bMin.value;
                Alist.remove(aMax);
                Blist.remove(bMin);
            } else {
                sum += aMin.value * bMax.value;
                Alist.remove(aMin);
                Blist.remove(bMax);
            }
        }

        // 순회를 마치면 결과를 반환한다.
        return sum;
    }

    // 일부문제 시간초과 발생
    public static int problem2(int stock, int[] dates, int[] supplies, int k) {
        // <날짜, 공급량> 맵 생성
        Map<Integer, Integer> datesToSupply = new HashMap<Integer, Integer>();
        for (int i = 0; i < dates.length; i++) {
            datesToSupply.put(dates[i], supplies[i]);
        }

        int currentStock = stock;
        int skippedSupplyDate = 0;
        int suppliedCount = 0;
        // 모든 경우의 수를 계산
        for (int day = 1; day < k; day++) {
            if (datesToSupply.containsKey(day))
                skippedSupplyDate = day;

            if (currentStock < 0) {
                currentStock += datesToSupply.get(skippedSupplyDate);
                suppliedCount++;
            }

            currentStock--;
        }

        // 가장 적게 공급받은 횟수를 반환
        return suppliedCount;
    }

    public static int problem3(int n) {
        int divider = 1234567;

        int[] fibos = new int[n + 1];
        fibos[0] = 0;
        fibos[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibos[i] = (fibos[i - 1] + fibos[i - 2]) % divider;
        }

        return fibos[n];
    }
}

class Pair {
    public int value;
    public int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}