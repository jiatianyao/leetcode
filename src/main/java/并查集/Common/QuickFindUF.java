package 并查集.Common;

public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];                 // Quick Find需要在最开始建立一个数组
        for (int i = 0; i < N; i++)      // 然后每个元素等于其索引（index）
            id[i] = i;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];           // 检查俩个元素是否相连
    }

    public int find(int p) {             // 查找p所连接的元素
        return id[p];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) { // 遍历整个数组
            if (id[i] == pid) id[i] = qid;    // 当检索到id[p]（即p所指向的元素），再将id[q]
        }                                     // 赋值id[p]（p,q现指向同一位置）
    }
}
