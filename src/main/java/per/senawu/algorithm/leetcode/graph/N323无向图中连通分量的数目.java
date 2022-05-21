package per.senawu.algorithm.leetcode.graph;

/**
 * @author Sena-wu
 * @date 2022/5/21
 * <p>
 * 给你输入一个包含 n 个节点的图，用一个整数 n 和一个数组 edges 表示，其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间有一条边。请你计算这幅图的连通分量个数。
 */

/**
 * 给你输入一个包含 n 个节点的图，用一个整数 n 和一个数组 edges 表示，其中 edges[i] = [ai, bi] 表示图中节点 ai 和 bi 之间有一条边。请你计算这幅图的连通分量个数。
 *
 */

/**
 * 并查集: 判断任一两个节点是否连通，连通则将其加入到同一个连通分量中
 * dfs: 对所有节点进行dfs遍历 有多少个节点能顺利开始遍历则有多少过连通分量
 */
public class N323无向图中连通分量的数目 {
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.getCount();
    }

    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            // 初始化每个节点的root为节点本身
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            // p、q属于同一个连通分量
            if (rootP == rootQ) {
                return;
            }
            // 合并两个连通分量
            parent[q] = rootP;
            count--;
        }

        public int findRoot(int x) {
            // 节点x的父节点都修改为顶级父节点
            if (parent[x] != x) {
                parent[x] = parent[parent[x]];
            }
            return parent[x];
        }

        public int getCount() {
            return count;
        }
    }

}
