package 深搜广搜;

import exam.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[["Q"]]
 *
 * https://leetcode-cn.com/problems/n-queens/
 */
public class l010_solveNQueens_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n==1){
            List<String> child = new ArrayList<>();
            child.add("Q");
            result.add(child);
            return result;
        }
        int[] visited = new int[n];
        Arrays.fill(visited,-1);
        bfs(visited,result,0);
        return result;
    }

    public void bfs(int[] visited,List<List<String>> result,int row){
        if(row == visited.length){
            setList(result,visited);
            return;
        }
        for (int j = 0; j < visited.length; j++) {
            if(!isOk(visited,row,j)){
                visited[row] = j;
                bfs(visited,result,row+1);
                visited[row] = -1;
            }
        }
    }

    private void setList(List<List<String>> result, int[] visited) {
        int n = visited.length;
        List<String> list = new ArrayList<>();
        for (int i : visited) {
            String s = setS(n, i);
            list.add(s);
        }
        result.add(list);
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

    public static void main(String[] args) {
        l010_solveNQueens_51 demo = new l010_solveNQueens_51();
        demo.solveNQueens(4);
    }
}
