package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/23
 */
/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */

/**
 * 方法很多种 最简单的就是直接遍历链表将结果存在在数组中，首尾两指针遍历数组进行判断
 *
 * 时间复杂度为n 空间复杂度为1的方法：
 * 1、链表只有一个节点 直接返回true
 * 2、找到链表的中间节点mid, 若果链表节点数为2n 返回第n 个节点做为中间节点
 * 3、反转链表mid.next 得到反转后的链表reverseList
 * 4、双指针: 从reverseList 和 头结点 开始遍历
 *      直至reverseList为null 或者 两个node的值不相等(还原链表 return false)
 * 5、反转reverseList 并与mid 拼接来还原链表
 */
public class N234回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null){
            return true;
        }
        ListNode mid = getMid(head);
        ListNode reverseList = reverse(mid.next);
        mid.next = reverseList;
        while(reverseList != null){
            if (reverseList.val != head.val){
                // 还原链表
                reverseList = reverse(mid.next);
                mid.next = reverseList;
                return false;
            }
            reverseList = reverseList.next;
            head = head.next;
        }
        reverseList = reverse(mid.next);
        mid.next = reverseList;
        return true;
    }

    ListNode getMid(ListNode head){
        if (head.next == null){
            return head;
        }
        ListNode quick =  head.next;
        ListNode slow = head;
        // quick 2n; slow n
        while (quick != null){
            // slow n; quick 2n
            if (quick.next == null){
                return slow;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        // show n; quick 2n-1
        return slow;
    }

    ListNode reverse(ListNode head){
        ListNode result = null;
        ListNode work = head;
        while(work != null){
            ListNode tmp = work.next;
            work.next = result;
            result = work;
            work = tmp;
        }
        return result;
    }
}
