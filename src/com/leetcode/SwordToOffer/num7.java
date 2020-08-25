package com.leetcode.SwordToOffer;

import java.util.HashMap;

public class num7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder==null || preorder.length==0) return null;
        HashMap<Integer,Integer> indexMap = new HashMap();
        for(int i=0;i< inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        int len = preorder.length;
        TreeNode head = buildTree(preorder,0,len-1,inorder,0,len-1,indexMap);
        return head;

    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inorStart, int inorEnd, HashMap<Integer, Integer> indexMap) {
        if(preStart>preEnd) return null;
        int rootVal = preorder[preStart];
        TreeNode head = new TreeNode(rootVal);
        if(preStart==preEnd) return head;
        int rootInd = indexMap.get(rootVal);
        int letNodes = rootInd - inorStart,rightNodes = inorEnd-rootInd;
        TreeNode leftNode = buildTree(preorder,preStart+1,preStart+letNodes,inorder,inorStart,rootInd-1,indexMap);
        TreeNode rightNode = buildTree(preorder,preEnd-rightNodes+1,preEnd,inorder,rootInd+1,inorEnd,indexMap);
        head.left=leftNode;
        head.right=rightNode;
        return head;

    }
}
