package 牛客.困难;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，
 * 推算出所有剩余空格的数字，并且满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复。
 * 输入：
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 * 输出：
 * 完整的9X9盘面数组
 *
 * 输入描述:
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 *
 * 输出描述:
 * 完整的9X9盘面数组
 *
 * 示例1
 * 输入
 * 0 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 0 4 5 2 7 6 8 3 1
 * 输出
 * 5 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 9 4 5 2 7 6 8 3 1
 */

public class HJ44 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){
            int[][] res = new int[9][9];

            int n = 0;
            while(n<9){
                String[] s = str1.split(" ");
                for (int i = 0; i < s.length; i++) {
                    res[n][i] = Integer.parseInt(s[i]);
                }
                if(n==8) break;
                str1 =  reader.readLine();
                n++;
            }
            // 填充数独
            dfs(res, 0, 0);
            // 打印数独
            for (int[] row : res) {
                for (int i = 0; i < 9; i++) {
                    System.out.print(row[i]);
                    if (i != 8) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    private static boolean dfs(int[][] res, int i, int j) {
        if(i==9) return true;
        if(res[i][j]==0){
            for (int k = 1; k <= 9; k++) {
                res[i][j] = k;
                if(check(res,i,j) && dfs(res,j ==8 ? i+1 : i,j==8? 0 :j+1)){
                    return true;
                }
            }
            res[i][j] = 0;
            return false;
        }else{
            return dfs(res,j ==8 ? i+1 : i,j==8? 0 : j+1);
        }
    }

    private static boolean check(int[][] res, int i, int j) {
        // 同行
        for (int k = 0; k < 9; k++) {
            if (k != j && res[i][k] == res[i][j]) {
                return false;
            }
        }
        // 同列
        for (int k = 0; k < 9; k++) {
            if (k != i && res[k][j] == res[i][j]) {
                return false;
            }
        }
        // 同九宫
        int up = i / 3 * 3;
        int left = j / 3 * 3;

        for (int k = up; k < up + 3; k++) {
            for (int l = left; l < left + 3; l++) {
                if ((k != i || l != j) && res[k][l] == res[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

