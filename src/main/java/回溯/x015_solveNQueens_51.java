package 回溯;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[["Q"]]
 */
public class x015_solveNQueens_51 {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        backtrack(n,arr,0,new LinkedList<>());
        return result;
    }

    public void backtrack(int n, int[] visit, int row,Deque<String> list){
        if(list.size() == n){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int col = 0; col < n; col++) {
            String s = setS(n, col);
            if(isOk(visit,row,col)) continue;
            visit[row] = col ;
            list.addLast(s);
            backtrack(n,visit,row+1,list);
            visit[row]=-1;
            list.removeLast();
        }
    }

    public String setS(int n,int index){
        String res = "";
        while (n>0){
            if(index+1 == n){
                res = "Q"+res;
            }else{
                res = "."+res;
            }
            n--;

        }
        return res;
    }

    public boolean isOk(int[] visit,int x2,int y2){
        for (int x = 0; x < visit.length; x++) {
            int y = visit[x];
            if(y==y2 ) return true;
            if(y==-1) continue;
            if(Math.abs(x2-x) == Math.abs(y2-y)){
                return true;
            }
        }
        return false;
    }
}



