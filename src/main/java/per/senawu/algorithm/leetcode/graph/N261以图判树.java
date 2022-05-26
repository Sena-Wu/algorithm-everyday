package per.senawu.algorithm.leetcode.graph;

/**
 * @author Sena-wu
 * @date 2022/5/26
 */

/**
 * 给你输入编号从 0 到 n - 1 的 n 个结点，和一个无向边列表 edges（每条边用节点二元组表示），请你判断输入的这些边组成的结构是否是一棵树。
 */

/**
 * 并查集：当某条边的两个节点已在同一连通分量中，则该边的加入会使图中有环，则不是一颗树
 */
public class N261以图判树 {
    public boolean validTree(int n, int[][] edges) {
        UnionFound unionFound = new UnionFound(n);
        for (int[] edge : edges) {
            if (unionFound.connect(edge[0], edge[1]) == false) {
                return false;
            }
        }
        return true;
    }

    class UnionFound {
        int[] root;

        public UnionFound(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        public boolean connect(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            if (rootP == rootQ) {
                return false;
            } else {
                root[rootQ] = rootP;
                return true;
            }
        }

        public int findRoot(int node) {
            if (root[node] != node) {
                root[node] = findRoot(root[node]);
            }
            return root[node];
        }

    }
}
