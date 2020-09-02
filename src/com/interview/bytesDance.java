package com.interview;

public class bytesDance {
    public int candy (int[] arr) {
        if(arr.length==0) return 0;
        if(arr.length==1) return 1;
        // write code here
        int ans = 1;
        int last = 1;
        int start =0;
        int small =1;
        while (last<arr.length){
            while(arr[last]<arr[start]&&last<arr.length) last++;
            ans+=(1+last+1)*(last+1)/2;
            start=last;
            last++;

        }

        return ans;
    }
    public static void main(String[] args) {
       bytesDance t = new bytesDance();
        System.out.println(t.candy(new int[]{5,4,3,2,1}));
    }
}
