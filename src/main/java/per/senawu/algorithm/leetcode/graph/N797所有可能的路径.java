package per.senawu.algorithm.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sena-wu
 * @date 2022/5/11
 */

/**
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）
 *
 * 链接：https://leetcode.cn/problems/all-paths-from-source-to-target
 */
public class N797所有可能的路径 {
    int [] visit;
    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        visit= new int[graph.length];
        result = new ArrayList();

        work(graph, new ArrayList<Integer>(), 0);
        return result;
    }

    void work(int[][] graph, List<Integer> path, int start){
        List<Integer> newPath = new ArrayList(path);
        newPath.add(start);

        if (start == graph.length -1){
            result.add(newPath);
            return;
        }
        if (graph[start] == null){
            return;
        }
        for (int i: graph[start]){
            if (visit[i] == 0){
                visit[i] = 1;
                work(graph, newPath, i);
                visit[i] = 0;
            }
        }
    }
}
