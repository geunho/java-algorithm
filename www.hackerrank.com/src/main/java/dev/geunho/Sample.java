package dev.geunho;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sample {

    public static String findNumber(List<Integer> arr, int k) {
        boolean exists = arr.stream().anyMatch(number -> number == k);
        return exists ? "YES" : "NO";
    }

    public static List<Integer> oddNumbers(int l, int r) {
        List<Integer> odds = new ArrayList<>();
        for (int number = l; number <= r; number++) {
            if (number % 2 != 0)
                odds.add(number);
        }
        return odds;
    }

    public static int reduceCapacity(List<Integer> model) {
        // int n = Math.ceil(model.size(), ) --> List 구현체에 따라 전체 길이 계산에 N번 순회가 필요할 수도
        // 있다. --> 모든 Collection 구현은 size 계산을 위해 로컬 맴버를 유지하고 있음. 따라서 O(1)
        int numberOfModels = 0;
        // map에 장비를 카운트
        Map<Integer, Integer> generatorCounts = new HashMap<>();
        for (int modelNumber : model) {
            int count = generatorCounts.getOrDefault(modelNumber, 0);
            generatorCounts.put(modelNumber, ++count);
            numberOfModels++;
        }

        // 전체 길이의 중단 대수 계산 ceil(model/2)
        int modelsToStop = (int) Math.ceil(numberOfModels / 2.0); // n

        // map의 값 리스트를 정렬
        List<Integer> sortedCount = generatorCounts.values().stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        // 중단 대수가 될때까지 합, 그때 순회 인덱스를 반환
        int generatorsStopped = 0; // 중단된 generator 수
        int modelsStopped = 0; // 중단된 model 종류 수
        for (int count : sortedCount) {
            if (generatorsStopped < modelsToStop) {
                generatorsStopped += count;
                modelsStopped++;
            } else {
                break;s
            }
        }

        return modelsStopped;
    }

    public static List<String> areAlmostEquivalent(List<String> firstStrings, List<String> secondStrings) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < firstStrings.size(); i++) {
            String first = firstStrings.get(i);
            String second = secondStrings.get(i);

            boolean answer = equivalentOrNot(first, second);
            result.add(answer ? "YES" : "NO");
        }

        return result;
    }

    public static boolean equivalentOrNot(String first, String second) {
        // char diff를 저장하는 map.
        // count(firstChar) - count(secondChar) 를 계산한다
        Map<Character, Integer> charDiffs = new HashMap<>();

        // 각각 집계 시작
        // length <= 100,000 O(n)
        for (int index = 0; index < first.length(); index++) {
            char fch = first.charAt(index);
            int fchCount = charDiffs.getOrDefault(fch, 0);
            charDiffs.put(fch, ++fchCount);

            char sch = second.charAt(index);
            int schCount = charDiffs.getOrDefault(sch, 0);
            charDiffs.put(sch, --schCount);
        }

        for (int diff : charDiffs.values()) {
            // 3 초과시 즉시 false 반환
            if (Math.abs(diff) > 3)
                return false;
        }

        // 모두 통과하면 true
        return true;
    }

    public static String compressWord(String word, int K) {
        // ascii list로 변환
        List<Integer> asciis = word.chars().boxed().collect(Collectors.toList());

        List<Integer> compressed = compress(asciis, K);

        for (;;) {
            // list 길이가 K보다 작으면 작업 중지
            int length = compressed.size();
            if (length < K)
                break;

            compressed = compress(compressed, K);

            // 압축 결과 길이가 기존과 같으면 작업 중지
            if (compressed.size() == length)
                break;
        }

        StringBuffer sb = new StringBuffer();
        for (int ascii : compressed) {
            sb.append((char) ascii);
        }

        return sb.toString();
    }

    public static List<Integer> compress(List<Integer> asciis, int K) {
        int length = asciis.size();
        // 순회하면서 K 만큼 연속된 문자 발견시 삭제
        for (int index = 0; index <= length - K; index++) {
            int ascii = asciis.get(index);
            boolean consecutive = true;

            // 연속성 확인
            for (int i = 1; i < K; i++) {
                if (ascii != asciis.get(index + i)) {
                    consecutive = false;
                    break;
                }
            }

            if (consecutive) {
                asciis.subList(index, index + K).clear();
                return asciis;
            }
        }

        // 수행 결과가 기존과 같으므로 그대로 반환
        return asciis;
    }
}