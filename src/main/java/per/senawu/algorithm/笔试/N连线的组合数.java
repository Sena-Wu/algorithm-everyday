package per.senawu.algorithm.笔试;

/**
 * @author Sena-wu
 * @date 2022/7/15
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给N个节点
 * 从中选三个节点，三个节点需要连成一条直线
 * 计算有多少种组合
 */
public class N连线的组合数 {
    public int solution(Point2D[] A) {
        // write your code in Java SE 8
        boolean[] flag = new boolean[A.length];
        Arrays.fill(flag, true);
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map3 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> map4 = new HashMap<Integer, Integer>();

        // 同一个key的节点可以连成一条线; 总共四个方向
        for(int i = 0; i < A.length; i++){
            int key = A[i].y - A[i].x;
            map1.put(key, map1.getOrDefault(key, 0) + 1);
        }
        for(int i = 0; i < A.length; i++){
            int key = A[i].x - A[i].y;
            map2.put(key, map1.getOrDefault(key, 0) + 1);
        }
        for(int i = 0; i < A.length; i++){
            int key = A[i].x;
            map3.put(key, map1.getOrDefault(key, 0) + 1);
        }
        for(int i = 0; i < A.length; i++){
            int key = A[i].y;
            map4.put(key, map1.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (Integer value : map1.values()) {
            if (value > 2){
                count += get(value);
            }
        }
        for (Integer value : map2.values()) {
            if (value > 2){
                count += get(value);
            }
        }
        for (Integer value : map3.values()) {
            if (value > 2){
                count += get(value);
            }
        }
        for (Integer value : map4.values()) {
            if (value > 2){
                count += get(value);
            }
        }
        return count;
    }

    static int get(int m){
        int up = 1;
        for(int i = m - 3 + 1; i <= m; i++){
            up *= i;
        }
        return up / 6;
    }

    static class Point2D{
        int x;
        int y;

        Point2D(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
