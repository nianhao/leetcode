package com.interview;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class zte1 {
    //排列前k大的数
    // 本题为考试单行多行输入输出规范示例，无需提交，不计分。
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
            while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
                int n = in.nextInt();
                int k = in.nextInt();
                if (n != k) {
                    for (int i = n - k + 1; i <= n - 1; i++) {
                        System.out.print(i);
                        out.print(" ");
                    }
                    out.print(n);
                    for (int i = 1; i < n - k + 1; i++) out.print(" " + i);
                } else {
                    for (int i = 1; i <= n; i++) out.print(i + " ");
                }
                out.flush();
            }
        }
    }
