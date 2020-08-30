package com.leetcode.SwordToOffer;

public class num14 {
    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        int num_3 = n/3;
        int rem = n%3;
        if(rem==0) return (int) Math.pow(3,num_3);
        if(rem==1) return (int) Math.pow(3,num_3-1)*4;
        return (int) Math.pow(3,num_3)*2;
    }
}
