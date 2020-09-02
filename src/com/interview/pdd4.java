package com.interview;

import java.util.Scanner;

public class pdd4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            int[] fea = new int[b];
            for(int i=0;i<b;i++)
                fea[i]=in.nextInt();
            int ans =0;
            boolean flag;
            for(int i=1;i<=a;i++){
                for(int j=0;j<b;j++){
                    if(i%fea[j]==0){
                        ans++;
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
