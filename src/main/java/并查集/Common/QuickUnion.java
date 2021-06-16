package 并查集.Common;

public class QuickUnion {
    private int[] id;

    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    private int root(int i) {
        while (i != id[i]) i = id[i]; // 不断向上遍历，直到找到root（即索引与其中元素相同）
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);         // 检验p,q的root是否相同
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;                     // 将q的root连接到p的root上
    }
}
