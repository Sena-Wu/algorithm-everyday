package per.senawu.algorithm.leetcode.graph;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Sena-wu
 * @date 2022/5/13
 */

/**
 * 现在你总共有 numCourses 门课需要选，记为  0  到  numCourses - 1。给你一个数组  prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修  bi 。
 * 例如，想要学习课程 0 ，你需要先完成课程  1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 *
 * 链接：https://leetcode.cn/problems/course-schedule-ii
 */

/**
 *  * 获取拓扑排序 ; (判断图中是否存在环)
 *  * 1、计算每个节点的入度
 *  * 2、循环：取入度为0的节点i; 将i的子节点的入度-1;
 *  * 3、所有节点均取出 得到拓扑排序结果(则不存在环)
 */
public class N210课程表 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] reuslt = new int[numCourses];
        int count = 0;
        int[] degree = new int[numCourses];
        HashSet<Integer>[] edges = new HashSet[numCourses];
        LinkedList<Integer> queue = new LinkedList();
        // 计算每个节点的入度及子节点
        for (int[] i : prerequisites){
            degree[i[0]]++;
            if (edges[i[1]] == null){
                edges[i[1]] = new HashSet<>();
            }
            edges[i[1]].add(i[0]);
        }
        // 入度为0的节点加入队列
        for (int i = 0; i < numCourses; i++){
            if (degree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int zero = queue.poll();
            reuslt[count++] = zero;
            // 将节点zero的子节点 i 的入度-1 ; i 的入度为0 则加入queue
            if (edges[zero] != null){
                for (int i: edges[zero]){
                    degree[i]--;
                    if (degree[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses? reuslt : new int[0];
    }
}
