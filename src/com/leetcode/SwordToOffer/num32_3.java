package com.leetcode.SwordToOffer;

import java.util.*;

public class num32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> s = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        TreeNode p ;
        while (!q.isEmpty()){
            List<Integer> tmp = new LinkedList<>();
            for(int i=q.size();i>0;i--){
                p = q.poll();

                if(p!=null){
                    s.push(p);
                    tmp.add(p.val);
                }

            }
            while (!s.empty()){
                p=s.pop();
                if(level%2==1) {
                    q.add(p.right);
                    q.add(p.left);
                }else{
                    q.add(p.left);
                    q.add(p.right);

                }
            }
            level++;
            ans.add(tmp);
        }
        return ans;




    }
}
