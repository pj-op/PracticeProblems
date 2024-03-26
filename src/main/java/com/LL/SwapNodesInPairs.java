package com.LL;

import lombok.Data;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;

        System.out.println(listNode1);
        System.out.println(swapPairs(listNode1));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode listNode = head.next;
        head.next = swapPairs(head.next.next);
        listNode.next = head;
        return listNode;
    }
}
//ListNode(val=1, next=ListNode(val=2, next=ListNode(val=3, next=ListNode(val=4, next=null))))

@Data
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
