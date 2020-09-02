package com.leetcodePro.solve;

import java.util.Arrays;

public class HuaWei {
    double findMedianSortedArray2(int[]nums1,int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int[] ans = new int[n];
        int indx=0;
        for(int i=0;i<n1;i++)
            ans[indx++]=nums1[i];
        for(int i=0;i<n2;i++)
            ans[indx++]=nums2[i];
        Arrays.sort(ans);
        if(n%2==0)
            return(ans[n/2]+(ans[n/2-1]+0.0))/2;
        else
            return ans[n/2]+0.0;
    }
    void findMedianSortedArray(int[]nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        if(n%2==0){
            int i=0;
            int j=0;
            for(;i<n1&&j<n2&&(i+j)<((n/2)-1);){
                if(nums1[i]<nums2[j]){

                }
            }
        }else{

        }
    }
}
