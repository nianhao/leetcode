package com.leetcode.SwordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num32 {




    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> ansA = new ArrayList<>();
        q.add(root);
        TreeNode p ;
        while (!q.isEmpty()) {
            p = q.poll();
            if (p != null) {
                ansA.add(p.val);
                q.add(p.left);
                q.add(p.right);
            }
        }
        int[] ans = new int[ansA.size()];
        for(int i=0;i<ansA.size();i++) {
            ans[i] = ansA.get(i);
        }
        return ans;

    }
}
