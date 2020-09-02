package com.interview;

import java.util.Scanner;

public class pdd3 {
    public static int dfs(int m,int[]c,int[]v,int i,int get){
        if(i==c.length) return get;
        if((m-c[i])>=0){
            return Math.max(dfs(m-c[i],c,v,i+1,get+v[i]),dfs(m,c,v,i+1,get));
        }else{
            return dfs(m,c,v,i+1,get);
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
            int[] c = new int[n];
            int[] v = new int[n];
            for(int i=0;i<n;i++)
            {
                c[i]=in.nextInt();
                v[i]=in.nextInt();
            }
            int ans= dfs(m,c,v,0,0);
            System.out.println(ans);
        }
    }
}
