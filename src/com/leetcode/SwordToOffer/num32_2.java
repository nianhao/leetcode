package com.leetcode.SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return null;
        Queue<Object[]> q=new LinkedList<>();

        q.add(new Object[]{root,0});
        TreeNode p;

        int level;
        while (!q.isEmpty()){

            p=(TreeNode)q.peek()[0];
            if(p==null) {q.poll();continue;}
            level=(int)q.poll()[1];
            if(ans.size()>level){
                ans.get(level).add(p.val);

            }else{
                List<Integer> l = new ArrayList<>();
                l.add(p.val);
                ans.add(level,l);
            }
            q.add(new Object[]{p.left,level+1});
            q.add(new Object[]{p.right,level+1});
        }
        return ans;

    }
}
