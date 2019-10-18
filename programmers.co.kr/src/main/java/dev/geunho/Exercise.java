package dev.geunho;

import java.util.HashSet;
import java.util.Set;

public class Exercise {
    public static int[] solution1(int[][] v) {
        // x, y set 선언
        Set<Integer> xSet = new HashSet<Integer>();
        Set<Integer> ySet = new HashSet<Integer>();
        
        // 순회하면서 set에 없으면 넣고, 있으면 삭제한다
        for (int i = 0; i < v.length; i++) {
            int[] p = v[i];
            int x = p[0];
            int y = p[1];
            if(xSet.contains(x)) {
                xSet.remove(x);
            } else {
                xSet.add(x);
            }
            if(ySet.contains(y)) {
                ySet.remove(y);
            } else {
                ySet.add(y);
            }
        }
        // set에 남은 두 개 값을 반환
        int x = (int)xSet.toArray()[0];
        int y = (int)ySet.toArray()[0];

        return new int[] { x, y };
    }

    public static void solution2(int a, int b) {
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }    

    
}