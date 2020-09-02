package com.interview;

import java.util.Scanner;

public class pdd2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输
            int n = in.nextInt();
            int m = in.nextInt();
            int [][] map = new int[n][m];
            int cnt =0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    map[i][j]=in.nextInt();
                    if(map[i][j]==1) cnt++;

                }
            }
            System.out.println(cnt);
        }
    }
}
