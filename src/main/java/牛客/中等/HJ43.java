package 牛客.中等;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * HJ43 迷宫问题
 * 题目描述
 * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 0, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,};
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，
 * 要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
 * 本题含有多组数据。
 *
 * 输入描述:
 * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。
 * 数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 *
 * 输出描述:
 * 左上角到右下角的最短路径，格式如样例所示。
 *
 * 示例1                    输出
 * 输入                    (0,0)
 * 5 5                     (1,0)
 * 0 1 0 0 0               (2,0)
 * 0 1 0 1 0               (2,1)
 * 0 0 0 0 0               (2,2)
 * 0 1 1 1 0               (2,3)
 * 0 0 0 1 0               (2,4)
 */
public class HJ43 {
    private static Stack<Point> tempPath = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 ="";
        while((str1 =  reader.readLine()) !=null){

            String[] s = str1.split(" ");
            int leftLen = Integer.parseInt(s[0]);
            int rightLen = Integer.parseInt(s[1]);
            int[][] a = new int[leftLen][rightLen];
            int i = 0;
            int j = leftLen;
            while(j>0){
                String s1 = reader.readLine();
                String[] s2 = s1.split(" ");
                for (int k = 0; k < rightLen; k++) {
                    String s3 = s2[k];
                    a[i][k] = Integer.parseInt(s3);
                }
                i++;
                j--;
            }

            dfs(a,0,0,leftLen,rightLen);

        }
    }

    private static void sout(int[][] a,int left,int right,int leftLen,int rightLen) {

        if(left<leftLen-1){
            if(a[left+1][right] !=1){
                System.out.println("("+left+","+right+")");
            }
        }

        if(right<rightLen-1){
            if(a[left+1][right] !=1){
                System.out.println("("+left+","+right+")");
            }
        }
    }

    public static void dfs(int[][] a,int x,int y,int rows,int cols){
        Point p = new Point(x, y);
        tempPath.push(p);
        a[x][y] = 1;
        if (x == rows - 1 && y == cols - 1) {
            for (Point point : tempPath){
                System.out.println("(" + point.x + "," + point.y + ")");
            }
        }
        if (x + 1 < rows && a[x + 1][y] == 0) { //下
            dfs(a,x + 1, y,rows,cols);
        }
        if (y + 1 < cols && a[x][y + 1] == 0){ //右
            dfs(a, x , y + 1,rows,cols);
        }
        a[x][y] = 0;
        tempPath.pop();
    }

}

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}




