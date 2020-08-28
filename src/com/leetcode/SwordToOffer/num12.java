package com.leetcode.SwordToOffer;

public class num12 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if(row==0) return false;
        int col = board[0].length;
        if(col==0) return false;


        boolean[][] vis = new boolean[row][col];

        int x,y;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                vis[i][j]=true;
                if(board[i][j]==word.charAt(0)&&exist(board,word,i,j,1,vis,new StringBuilder().append(board[i][j]))) return true;
                vis[i][j]=false;
            }
        }
        return false;

    }

    private boolean exist(char[][] board, String word, int startX,int startY,int len,boolean[][]vis,StringBuilder roadW) {
        if(len==word.length()){
            if(word.equals(roadW.toString())) return true;
            else return false;
        }
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        for(int i=0;i<4;i++){
            int nx = startX+dx[i];
            int ny = startY+dy[i];
            if(nx>=0&&nx< board.length&&ny>=0&&ny<board[0].length&&vis[nx][ny]==false&&board[nx][ny]==word.charAt(len)){
            vis[nx][ny]=true;
            if(exist(board,word,nx,ny,len+1,vis,roadW.append(board[nx][ny]))) return true;
            roadW.deleteCharAt(len);
            vis[nx][ny]=false;}
        }
        return false;

    }

    public static void main(String[] args) {
        num12 n = new num12();
        System.out.println(n.exist(new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D',}},"AAB"));
    }
}
