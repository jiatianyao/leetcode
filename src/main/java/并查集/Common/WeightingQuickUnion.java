package 并查集.Common;

public class WeightingQuickUnion {

    private int[] id;
    private int[] size;                // size[i] = root为i的子树的数量

    public WeightingQuickUnion(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int find(int i) {
        while (i != id[i]) {
            i = id[i];         // 不断向上遍历，直到找到root（即索引与其中元素相同）
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);         // 检验p,q的root是否相同
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // 使较小的root指向较大的root
        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

}
