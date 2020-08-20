public class num2 {
      public class ListNode {
         int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode root  = new ListNode(0);
            ListNode cur = root;
            int retain = 0;
            while (l1!=null || l2!=null || retain!=0) {
                int l1_val = l1==null ? 0 : l1.val;
                int l2_val = l2==null ? 0 : l2.val;
                int sum = l1_val+l2_val+retain;
                //cur.val = sum%10;
                cur.next = new ListNode(sum%10);
                cur = cur.next;
                retain = sum /10;

                if(l1!=null) l1 = l1.next;
                if(l2!=null) l2 = l2.next;
            }
            cur.next=null;
            return root.next;
        }
    }
}
