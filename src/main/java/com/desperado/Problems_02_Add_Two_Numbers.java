package com.desperado;

import org.junit.Test;

public class Problems_02_Add_Two_Numbers {


    /**
     * 解题思路
     * 可以先建⽴⼀个虚拟头结点，这个虚拟头结点的 Next 指向真正的 head，这样
     * head 不需要单独处理，直接 while 循环即可。另外判断循环终⽌的条件不⽤是 p.Next ！= nil，这样最
     * 后⼀位还需要额外计算，循环终⽌条件应该是 p != nil。
     */
    private ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null){
            return null;
        }
        ListNode head = new ListNode(0,null);
        ListNode current = head;
        int carry = 0;
        while (l1 != null || l2 != null){
            int x, y;
            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;
            current.next = new ListNode((x + y + carry) % 10, null);
            current = current.next;
            carry = (x + y + carry) / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            current.next = new ListNode(carry % 10, null);
        }
        return head.next;
    }



    @Test
    public void test(){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);
        print(listNode);


        l1 = new ListNode(0);
        l2 = new ListNode(0);
        listNode = addTwoNumbers(l1, l2);
        print(listNode);


        l1 = new ListNode(9);
        l1.next=new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        listNode = addTwoNumbers(l1, l2);
        print(listNode);

    }


    private void print(ListNode listNode){
        while (listNode != null){
            System.out.print(listNode.val);
            System.out.print("->");
            listNode = listNode.next;
        }
        System.out.print("nil");
        System.out.println();
    }

    public class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
