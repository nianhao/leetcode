package com.interview;

import java.util.Scanner;

public class pdd1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int[][] matrix = new int[a][a];
                if(a<=3){


                }
                else{
                    if(a%2==0){
                        int num = (a/2)-1;
                        for(int i=0;i<num;i++){
                            for(int j=0;j<num-i;j++){
                                matrix[i][(a/2)-1-j]=2;
                                matrix[i][(a/2)+j]=1;
                                matrix[(a/2)-1-j][i]=3;
                                matrix[(a/2)+j][i]=4;
                                matrix[a-i-1][(a/2)-1-j]=5;
                                matrix[a-i-1][(a/2)+j]=6;
                                matrix[a/2+j][a-1-i]=7;
                                matrix[a/2-1-j][a-1-i]=8;
                            }

                        }
                    }else{
                        int num = (a/2)-1;
                        for(int i=0;i<num;i++) {
                            for (int j = 0; j < num - i; j++) {
                                matrix[i][(a / 2) - 1 - j] = 2;
                                matrix[i][(a / 2) + 1 + j] = 1;
                                matrix[(a / 2) - 1 - j][i] = 3;
                                matrix[(a / 2) + j+1][i] = 4;
                                matrix[a - i - 1][(a / 2) - 1 - j] = 5;
                                matrix[a - i - 1][(a / 2) + j+1] = 6;
                                matrix[a / 2 + j+1][a - 1 - i] = 7;
                                matrix[a / 2 - 1 - j][a - 1 - i] = 8;
                            }
                        }
                    }
                }
            for(int i=0;i<a;i++){
                for(int j=0;j<a;j++){
                    System.out.print(matrix[i][j]);
                    if(j<a-1) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
