package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/4/18
 */

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class N21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list2 == null){
            return list1;
        }
        if (list1 == null){
            return list2;
        }
        // 升序
        // 总是让list1表示第一个值更小的链表
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
