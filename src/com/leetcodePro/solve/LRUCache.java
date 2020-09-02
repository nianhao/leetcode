package com.leetcodePro.solve;

import java.util.HashMap;

public class LRUCache {
    class DLinkNode {
        int val;
        int key;
        DLinkNode pre;
        DLinkNode next;
        public DLinkNode(int _key,int _val){
            key = _key;
            val = _val;
        }
        public DLinkNode(){
            
        }

    }
    HashMap<Integer,DLinkNode> cache;
    DLinkNode head,tail;
    int capacity,size;
    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
        this.capacity=capacity;
        this.size=0;


    }

    public int get(int key) {
        DLinkNode cur = cache.getOrDefault(key,null);
        if(cur!=null){
            moveToHead(cur);
            return cur.val;
        }
        return -1;
        

    }



    public void put(int key, int value) {
        DLinkNode cur = cache.getOrDefault(key,null);
        if(cur!=null){
            cur.val=value;
            moveToHead(cur);
        }else{
            if(this.size==this.capacity){
                DLinkNode removeNode = removeTail();
                cache.remove(removeNode.key);
                cur = new DLinkNode(key,value);
                cache.put(key,cur);
                addToHead(cur);
            }else if(this.size<this.capacity){
                this.size++;
                cur = new DLinkNode(key,value);
                cache.put(key,cur);
                addToHead(cur);

            }
        }

    }

    private DLinkNode removeTail() {
        DLinkNode tN = tail.pre;
        removeNode(tN);
        return tN;

    }
    private  void removeNode(DLinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private void addToHead(DLinkNode cur) {
        cur.next=head.next;
        head.next.pre=cur;
        cur.pre = head;
        head.next=cur;
    }
    private void moveToHead(DLinkNode cur) {
        removeNode(cur);
        addToHead(cur);
    }

}
