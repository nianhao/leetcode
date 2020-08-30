package com.leetcode.SwordToOffer;

public class num22 {
    ListNode reverseList(ListNode head){
        ListNode p = null;
        ListNode q = null;
        ListNode cur = head;
        while(q!=null){
            q = cur.next;
            cur.next=p;
            p=cur;
            cur=q;

        }
        return cur;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail=head;
        for(int i=2;i<6;i++){
            tail.next = new ListNode(i);
            tail=tail.next;

        }
        num22 n = new num22();
        ListNode q = n.reverseList(head);
        while(q!=null){
            System.out.println(q.val);
            q=q.next;
        }
    }

}
