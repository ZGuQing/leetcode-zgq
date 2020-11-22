//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 406 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return null;
        ListNode l1 = head;
        ListNode mid = fideMiddleNode(head);
        ListNode l2 = mid.next;
        mid.next = null;//断链
        l2 = reverseList(l2);
        mergeList(l1,l2);
    }

    //快慢指针寻找中间节点
    public ListNode fideMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //链表逆转
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode cnext = curr.next;//指向当前节点的下个节点，防止断链
            curr.next = prev;//当前节点指向先前节点
            prev = curr;//
            curr = cnext;
        }
        return prev;
    }

    //合并链表
    public void mergeList(ListNode l1,ListNode l2){
        ListNode l1_temp;
        ListNode l2_temp;
        while(l1 != null && l2 != null){
            l1_temp = l1.next;
            l2_temp = l2.next;

            l1.next = l2;
            l1 = l1_temp;
            l2.next = l1;
            l2 = l2_temp;
        }
    }
}

public class ListNode {
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
//leetcode submit region end(Prohibit modification and deletion)
