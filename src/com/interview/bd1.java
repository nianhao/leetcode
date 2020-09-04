package com.interview;

import java.math.BigInteger;
import java.util.Scanner;

public class bd1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //StringBuilder s = new StringBuilder();
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int[] ans = new int[a];
            int cnt5 =0;

            for(int i=0;i<a;i++){
                ans[i]=in.nextInt();
                if(ans[i]==5) cnt5++;
            }
            if(cnt5==a) System.out.println(-1);
            else{
                int div = cnt5/9*9;
                int zero=a-cnt5;
                for(int i=0;i<div;i++) System.out.print("5");;
                for (int i=0;i<zero;i++) System.out.print("0");;
            }
        }
    }

}
