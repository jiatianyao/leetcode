package 回溯;

public class x016_solveSudoku_37 {

    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    public boolean dfs(char[][] board, int i, int j) {
        if(i==9) return true;
        if(board[i][j] == '.'){
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) (k + '0');
                if(isOk(board,i,j) &&  dfs(board,j ==8 ? i+1 : i,j==8? 0 :j+1)){
                    return true;
                }

            }
            board[i][j] = '.';
            return false;
        }else{
            return dfs(board,j ==8 ? i+1 : i,j==8? 0 : j+1);
        }

    }

    private boolean isOk(char[][] board, int i, int j) {
        // 同行
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == board[i][j]) {
                return false;
            }
        }
        // 同列
        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j]) {
                return false;
            }
        }
        // 同九宫
        int up = i / 3 * 3;
        int left = j / 3 * 3;

        for (int k = up; k < up + 3; k++) {
            for (int l = left; l < left + 3; l++) {
                if ((k != i || l != j) && board[k][l] == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
