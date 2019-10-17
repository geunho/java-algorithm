package dev.geunho;

import java.util.ArrayList;
import java.util.List;

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
}