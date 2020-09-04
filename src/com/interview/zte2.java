package com.interview;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class zte2 {
    public static int djstl(int start,int end,int n){
        int ans =-1;
        boolean[][] vis = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();
        return -1;
    }
    //图上搜索最短路
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            //int[]x=new int[m],y=new int[m],l=new int[m];
            int x,y,l;
            int[][] graph = new int[n+1][n+1];
            for(int i=0;i<m;i++){
                x=in.nextInt();
                y=in.nextInt();
                l=in.nextInt();
                graph[x][y]=graph[y][x]=l;
            }
            int a,b;
            for(int i=0;i<q;i++){
                a=in.nextInt();
                b=in.nextInt();
            }

        }
    }
}
