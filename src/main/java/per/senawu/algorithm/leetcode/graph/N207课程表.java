package per.senawu.algorithm.leetcode.graph;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Sena-wu
 * @date 2022/5/12
 */

/**
 *你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 链接：https://leetcode.cn/problems/course-schedule
 */

/**
 * 判断图中是否存在环 ; (获取拓扑排序)
 * 1、计算每个节点的入度
 * 2、循环：取入度为0的节点i; 将i的子节点的入度-1;
 * 3、所有节点均取出 则不存在环(得到拓扑排序结果)
 */
public class N207课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        int[] degree = new int[numCourses];
        HashSet<Integer>[] edges = new HashSet[numCourses];
        // 计算每个节点的入度及子节点
        for (int[] i : prerequisites){
            degree[i[0]]++;
            if (edges[i[1]] == null){
                edges[i[1]] = new HashSet<Integer>();
            }
            edges[i[1]].add(i[0]);
        }

        // 入度为0的节点加入队列
        LinkedList<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses;i++){
            if(degree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            count++;
            int zero = queue.poll();
            // 将节点zero的子节点 i 的入度-1 ; i 的入度为0 则加入queue
            if (edges[zero] != null){
                for (int i : edges[zero]){
                    degree[i]--;
                    if (degree[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses ? true : false;
    }
}
