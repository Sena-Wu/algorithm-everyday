package per.senawu.algorithm.leetcode.graph;

/**
 * @author Sena-wu
 * @date 2022/5/13
 */

/**
 * 存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。给你一个二维数组 graph ，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
 * 不存在自环（graph[u] 不包含 u）。
 * 不存在平行边（graph[u] 不包含重复值）。
 * 如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
 * 这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
 * 二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
 *
 * 如果图是二分图，返回 true ；否则，返回 false 。
 *
 * 链接：https://leetcode.cn/problems/is-graph-bipartite
 */

/**
 * 二分图: 将图中的节点划入两个不相交的集合, 同一个集合中的节点不存在边
 * 对一条边连接的两个节点 w v 上不同的颜色;
 *      1、每个节点都能成功上色 则可以将图中的所有节点划分为两个集合
 *      2、存在一个节点不能上色 则不能将图中的所有节点划分为两个集合
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
