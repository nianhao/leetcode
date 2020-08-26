package com.leetcode.SwordToOffer;

import java.util.Stack;

public class num9 {
    static class CQueue {

        private Stack<Integer> s1 ;
        private Stack<Integer> s2 ;
        public CQueue() {
            s1 = new Stack();
            s2 = new Stack();


        }

        public void appendTail(int value) {
            s1.push(value);

        }

        public int deleteHead() {
            if(s1.size()==0) return -1;
            while (s1.size()>1){
                s2.push(s1.pop());
            }
            int ans= s1.pop();
            while (!s2.empty()){
                s1.push(s2.pop());
            }
            return ans;

        }
    }

    public static void main(String[] args) {
          CQueue obj = new CQueue();
    obj.appendTail(5);
     int param_2 = obj.deleteHead();
    }
}
