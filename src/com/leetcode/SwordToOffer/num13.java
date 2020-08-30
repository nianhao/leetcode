package com.leetcode.SwordToOffer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class num13 {
    public int movingCount(int m, int n, int k) {
        if(k==0) return 1;
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        boolean[][] vis = new boolean[m][n];
        vis[0][0]=true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int ans = 1;

        int nx,ny;
        int[] node;
        while (!q.isEmpty()){
            node=q.poll();

            for(int i=0;i<4;i++){
                nx=node[0]+dx[i];
                ny = node[1]+dy[i];
                if(nx>=0&&nx<m&&ny>=0&&ny<n&&vis[nx][ny]==false&&canMove(nx,ny,k)){
                    q.add(new int[]{nx,ny});
                    vis[nx][ny]=true;
                    ans++;

                }
            }


        }
        return ans;

    }

    private boolean canMove(int nx, int ny, int k) {
        while (nx>0){
            k-=(nx%10);
            nx/=10;
        }
        while (ny>0){
            k-=(ny%10);
            ny/=10;
        }
        return k>=0;
    }

    public static void main(String[] args) {
        num13 n = new num13();
        System.out.println(n.movingCount(36,11,15));
    }
}
