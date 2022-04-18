package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/18
 */

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */

/**
 * 利用归并排序的思想与方法递归的对链表进行合并排序
 */
public class N23合并K个有序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        return work(lists, 0, lists.length -1);


    }
    public ListNode work(ListNode[] lists, int low, int high){
        if (low > high){
            return null;
        }
        if (low < high){
            ListNode left = work(lists, low, (low+high)/2);
            ListNode right = work(lists, (low+high)/2 + 1, high);

            return mergeTwoLists(left, right);
        }
        return lists[low];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list2 == null){
            return list1;
        }
        if (list1 == null){
            return list2;
        }
        if (list2.val <= list1.val){
            ListNode temp = list2;
            list2 = list1;
            list1 = temp;
        }
        ListNode prenode = list1;
        ListNode head = list1;
        list1 = list1.next;
        while (list2 != null && list1 != null){
            if (list2.val < list1.val){
                prenode.next = list2;
                list2 = list2.next;
                prenode = prenode.next;
                prenode.next = list1;
            }else{
                prenode = list1;
                list1 = list1.next;
            }
        }
        if (list2 == null){
            prenode.next = list1;
        }else{
            prenode.next = list2;
        }
        return head;
    }
}
