package com.leetcode.SwordToOffer;


import java.util.LinkedList;
import java.util.Stack;

public class num6 {
    public int[] reversePrint(ListNode head) {

        try {
            Thread.sleep(10);
            double ans = Double.parseDouble("s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Stack<Integer> values = new Stack();
        int count = 0;
        while (head!=null){
            values.push(head.val);
            head=head.next;
            count++;
        }
        int[] ans = new int[count];
        int ind = 0;
        for(int i=0;i<count;i++){
            ans[i]= values.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
