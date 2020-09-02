package com.interview;

import java.util.Scanner;

public class pdd3_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
            int[] c = new int[n];
            int[] v = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = in.nextInt();
                v[i] = in.nextInt();
            }
            int[][] dp = new int[n + 1][m + 1];
            int takeV;
            int noTakeV;
            for (int i = 1; i <= n; i++) {
                for (int k = 1; k <= m; k++) {
                    takeV = (k - c[i-1] >= 0) ? v[i - 1] + dp[i - 1][k - c[i - 1]] : 0;
                    noTakeV = dp[i - 1][k];
                    dp[i][k] = Math.max(takeV, noTakeV);
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
