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

        WindowQueue queue = new WindowQueue(W);

        for (;;) {
            // 입력 값과 개수가 매우 크므로 (> int) 매 입력마다 처리하도록 해야함
            String line = br.readLine();
            if (line == null || line.isEmpty()) return;

            long number = Long.valueOf(line);
            queue.add(number);

            // 윈도우 크기에 도달하면 윈도우 값 중 가장 큰 값을 출력
            if (queue.isFull()) {
                long max = queue.max();
                System.out.println(max);
            }
        }
    }
}

class WindowQueue {
    private final long maxSize;

    // LinkedList.size() 최대 값은 Integer.MAX_VALUE 이므로 long형 멤버를 선언
    private long count;
    private LinkedList<Long> innerList;
    // <값, 개수> 트리 맵
    TreeMap<Long, Integer> orderdedWindow;

    public WindowQueue(long maxSize) {
        this.innerList = new LinkedList<>();
        this.orderdedWindow = new TreeMap<>();
        this.count = 0;
        this.maxSize = maxSize;
    }

    public void add(long value) {
        this.innerList.addLast(value);

        int occurrence = orderdedWindow.getOrDefault(value, 0);
        orderdedWindow.put(value, ++occurrence);

        this.count++;

        if (this.count > this.maxSize) {
            // 최대 크기를 넘어가면 가장 먼저 입력된 값을 제거
            long shouldRemoved = this.innerList.removeFirst();

            int subOccurrence = orderdedWindow.get(shouldRemoved) - 1;
            if (subOccurrence == 0) { // 0이 되면 노드를 제거
                orderdedWindow.remove(shouldRemoved);
            } else {
                orderdedWindow.put(shouldRemoved, subOccurrence);
            }

            this.count--;
        }
    }

    public long size() {
        return this.count;
    }

    public long max() {
        return orderdedWindow.lastKey();
    }

    public boolean isFull() {
        return this.count == this.maxSize;
    }
}

