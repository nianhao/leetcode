public class num249_game_of_life {
    public static int check(int[][]board,int row,int col){
        int[] dx = new int[]{-1,0,1};
        int[] dy = new int[]{-1,0,1};
        int liveNum=0;
        int deadNum=0;
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(dx[i]==0&&dy[j]==0) continue;
                int x = row+dx[i];
                int y = col+dy[j];
                if(x>=0&&y>=0&&x<rows&&y<cols){
                    if(board[x][y]==0) deadNum++;
                    if(board[x][y]==1) liveNum++;
                }
            }
        }
        if(liveNum<2) return 0;
        if(liveNum==2) return board[row][col];
        if(liveNum==3) return 1;
        return 0;
    }
    public static void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int [][] newBoard = new int [row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++)
                newBoard[i][j]=board[i][j];
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j]=check(newBoard,i,j);
            }
        }

    }

    public static void main(String[] args) {
        int[][] b = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};

        gameOfLife(b);
    }
}
