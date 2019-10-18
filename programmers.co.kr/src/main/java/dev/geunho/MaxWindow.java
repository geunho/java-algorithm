package dev.geunho;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.TreeMap;

class myCode4 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // -3,000,000,000 ≦ Nn ≦ 3,000,000,000
        // 0 < W ≦ 3,000,000,000

        //             3,000,000,000 (target)
        //             2,147,483,647 (   int)
        // 9,223,372,036,854,775,807 (  long)
        long W = Long.valueOf(br.readLine());

        // 입력 값과 개수가 매우 크므로 (> int) 매 입력마다 처리하도록 해야함
        // endline이 없음

        // <값, 개수> 트리 맵 생성 
        TreeMap<Long, Integer> orderdedWindow = new TreeMap<>();
        // ArrayList는 배열 개수 제한인 int 크기 제한이 있으므로 LinkedList 사용
        LinkedList<Long> queue = new LinkedList<>();
        
        for (;;) {
            String line = br.readLine();
            if (line == null) return;

            long number = Long.valueOf(line);            

            // 스트림 값이 입력될 때마다 queue와 tree에 입력
            queue.add(number);

            // tree에 이미 값이 있다면 카운트 증가
            if (orderdedWindow.containsKey(number)) {
                int count = orderdedWindow.get(number);
                orderdedWindow.put(number, ++count);
            } else {
                orderdedWindow.put(number, 1);
            }

            // 윈도우 크기에 도달하면 tree의 마지막 값 (가장 큰 수) 출력
            if (queue.size() == W) {
                long max = orderdedWindow.lastKey();
                System.out.println(max);
            } else if (queue.size() > W) {
                // 이후 값이 입력될 때마다 첫 번째 값을 제거
                long shouldRemoved = queue.removeFirst();

                // tree의 카운트 감소
                int count = orderdedWindow.get(shouldRemoved) - 1;
                if (count == 0) { // 카운트가 0이 되면 노드를 제거
                    orderdedWindow.remove(shouldRemoved);
                } else {
                    orderdedWindow.put(shouldRemoved, count);
                }

                long max = orderdedWindow.lastKey();
                System.out.println(max);
            }
        }
    }
}