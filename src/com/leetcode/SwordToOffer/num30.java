package com.leetcode.SwordToOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num30 {
    class MinStack {

        /** initialize your data structure here. */
        Stack<Integer> resp;
        Stack<Integer> minResp;
        public MinStack() {
            resp = new Stack<>();
            minResp = new Stack<>();

        }

        public void push(int x) {
            resp.push(x);

            if(minResp==null||minResp.peek()>=x) minResp.push(x);

        }

        public void pop() {
            int x = resp.pop();
            if(x==minResp.peek()) minResp.pop();

        }

        public int top() {
            return resp.size()==0?-1:resp.peek();

        }

        public int min() {
            return minResp.peek();

        }
    }
}
