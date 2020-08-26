package com.leetcode.SwordToOffer;

public class num11 {
    public int minArray(int[] numbers) {
        if(numbers==null||numbers.length==0) return 0;
        if(numbers.length==1) return numbers[0];
        int low =0,heigh=numbers.length-1;
        int mid ;
        while (heigh>low){
            mid = (low+heigh)/2;
            if(numbers[mid]>numbers[heigh]){
                low = mid+1;
            }else if(numbers[mid]< numbers[heigh]){
                heigh=mid;
            }else if(numbers[mid]== numbers[heigh]){
                heigh--;
            }
        }
        return numbers[low];

    }
}
