package top.elgong.leetcode;

public class removeEndOfLinkedList19 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
 /*
   思路：快慢指针
        快指针先走 n + 1步， 然后和慢指针一起走， 快指针到结尾时， 慢指针的下一个就是要删除的点

   特殊情况：  被删除的正好是头：如果移动 n + 1步时， 出现 null， 则移除的就是头部

   其他思路： 哨节点可以。。。


   time:  O(1)
   space:  O(1)

 */

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (n <= 0){
            return head;
        }

        ListNode slow = head;
        ListNode quick = head;

        // 快指针 先移动 n+1 步
        for (int i = 0; i <= n; i++){

            // 当 n 刚好是列表长度， 则会 null
            if (quick == null){
                // 待删除的节点 是头结点
                return head.next;
            }
            quick = quick.next;
        }

        // 快慢指针同时出发
        while (quick != null){
            quick = quick.next;
            slow = slow.next;
        }

        // 慢指针的下一位是要删除的位置
        slow.next = slow.next.next;

        return head;
    }

}
