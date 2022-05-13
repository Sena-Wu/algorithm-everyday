package per.senawu.algorithm.leetcode.graph;

import java.util.LinkedList;

/**
 * @author Sena-wu
 * @date 2022/5/13
 */
public class N785判断二分图 {

    boolean[] visit;
    boolean[] color;
    boolean ok = true;
    public boolean isBinaryPartite(int[][] graph) {
        visit = new boolean[graph.length];
        color= new boolean[graph.length];

        // 不是连通图 可能存在多个子图 对每个节点进行遍历
        for (int node = 0; node < graph.length; node++){
            if (visit[node] == false){
                work(graph, node);
            }
        }
        return ok;
    }

    public void work(int[][] graph, int v){
        if (ok == false){
            return;
        }
        visit[v] = true;
        for (int w : graph[v]) {
            if (!visit[w]) {
                // 相邻节点 w 没有被访问过
                // 那么应该给节点 w 涂上和节点 v 不同的颜色
                color[w] = !color[v];
                // 继续遍历 w
                work(graph, w);
            } else {
                // 相邻节点 w 已经被访问过
                // 根据 v 和 w 的颜色判断是否是二分图
                if (color[w] == color[v]) {
                    // 若相同，则此图不是二分图
                    ok = false;
                }
            }
        }
    }
}
