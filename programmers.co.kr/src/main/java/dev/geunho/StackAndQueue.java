package dev.geunho;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class StackAndQueue {

    /**
     * 기능개발 https://programmers.co.kr/learn/courses/30/lessons/42586
     * 
     * @param progresses
     * @param speeds
     * @return listOfDeploys
     */
    public static int[] 기능개발(int[] progresses, int[] speeds) {
        List<Integer> days = new ArrayList<Integer>();
        int precedingDaysLeft = -1;

        // 순회하면서 걸리는 시간 계산 : N
        for (int index = 0; index < progresses.length; index++) {
            int progress = progresses[index];
            int speed = speeds[index];

            // ceil((100 - progress) / speed)
            int daysLeft = (int) Math.ceil((100.0 - (long) progress) / speed);

            // 선행 작업의 시간보다 적거나 같은 값이 걸릴때까지 결과 배열 값을 증가
            if (daysLeft <= precedingDaysLeft) {
                int last = days.size() - 1;
                days.set(last, days.get(last) + 1);
            } else {
                // 더 크다면 다음 결과 배열로 넘어가고 다시 위의 과정 반복
                days.add(1);
                precedingDaysLeft = daysLeft;
            }
        }

        int[] answer = days.stream().mapToInt(Integer::valueOf).toArray();
        return answer;
    }

    /**
     * 프린터 https://programmers.co.kr/learn/courses/30/lessons/42587
     * 
     * @param priorities
     * @param location
     * @return
     */
    public static int 프린터(int[] priorities, int location) {
        Queue<PriorityIndex> origin = new LinkedList<PriorityIndex>();

        // 순회하면서 우선순위와 위치를 저장한 자료구조를 생성
        for (int loc = 0; loc < priorities.length; loc++) {
            int priority = priorities[loc];
            PriorityIndex pi = new PriorityIndex(priority, loc);
            origin.offer(pi);
        }

        // 내림차순 정렬한 큐(A)와 정렬하지 않은 큐(B) 생성
        Queue<PriorityIndex> ordered = origin.stream().sorted((pi1, pi2) -> pi2.getPriority() - pi1.getPriority())
                .collect(Collectors.toCollection(LinkedList::new));

        int order = 0;
        // 각 큐에서 값을 꺼내서 A > B면 B는 다시 enqueue,
        while (!origin.isEmpty()) {
            PriorityIndex orderedPi = ordered.peek();
            PriorityIndex originPi = origin.poll();

            if (orderedPi.getPriority() > originPi.getPriority()) {
                origin.offer(originPi);
            } else {
                // 아니라면 카운트를 증가시키고
                // 해당 값의 인덱스가 location과 일치하면 카운트 반환,
                // 아니라면 next z
                order++;
                ordered.remove();
                if (originPi.getLocation() == location) {
                    return order;
                }

            }
        }

        return order;
    }

}

class PriorityIndex {
    private int priority;
    private int location;

    public PriorityIndex(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getLocation() {
        return this.location;
    }
}