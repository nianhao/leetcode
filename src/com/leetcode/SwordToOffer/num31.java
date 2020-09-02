package com.leetcode.SwordToOffer;

import java.util.Stack;

public class num31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length) return false;
        if(pushed.length<2) return true;
        int in=0,out=0;
        Stack<Integer> s = new Stack();
        s.push(pushed[in++]);
        while(in<pushed.length){
            while (!s.empty()&&out<popped.length&&s.peek()==popped[out]){
                out++;
                s.pop();
            }
            s.push(pushed[in++]);

        }
        while (!s.empty()&&out< popped.length&&s.peek()== popped[out]){s.pop();out++;}
        return s.empty();
    }
}
