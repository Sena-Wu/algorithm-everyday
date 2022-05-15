package per.senawu.algorithm.leetcode.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Sena-wu
 * @date 2022/5/15
 */

/**
 *给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 * 链接：https://leetcode.cn/problems/possible-bipartition
 */

/**
 * 判断一个图是否是二分图: 能否给该图成功染色(两种颜色), 每条边连接的两个节点染上不同的颜色。
 */
public class N886可能的二分法 {
    boolean[] visited;
    boolean[] color;
    boolean ok = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : dislikes) {
            int v = edge[1];
            int w = edge[0];
            // 「无向图」相当于「双向图」
            // v -> w
            graph[v].add(w);
            // w -> v
            graph[w].add(v);
        }
        for (int i = 1; i <= n; i++){
            if (!visited[i]){
                work(graph, i);
            }
        }
        return ok;
    }

    public void work(List<Integer>[] graph, int start){
        if (!ok){
            return;
        }

        visited[start] = true;
        for (Integer node : graph[start]){
            if (!visited[node]){
                color[node] = !color[start];
                work(graph, node);
            }else if(color[node] == color[start]){
                ok = false;
            }
        }
    }
}
