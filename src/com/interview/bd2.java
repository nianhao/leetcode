package com.interview;

import java.util.Scanner;

public class bd2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //StringBuilder s = new StringBuilder();
        int t = in.nextInt();
        while (t>0){
            t--;
            int n=in.nextInt();
            int m = in.nextInt();
            int l,r,k;
            int[] cow = new int[n+1];
            int[] vis = new int[n+1];
            for(int i=0;i<m;i++){

                k = in.nextInt();
                for(int j=0;j<k;j++){
                    l = in.nextInt();
                    r=in.nextInt();
                    for(int p=l;p<=r;p++) {
                        if(vis[p]<(i+1)){
                            cow[p]++;
                            vis[p]=i+1;
                        }

                    }
                }
            }
            int ans = 0;
            for(int i=1;i<=n;i++){
                if(cow[i]==m) ans++;
            }
            System.out.println(ans);
            boolean first  = true;
            for(int i=1;i<=n;i++){
                if(cow[i]==m)
                    if(first){System.out.print(i);first=false;}
                    else System.out.print(" "+i);
            }
            System.out.println();
        }
    }
}
