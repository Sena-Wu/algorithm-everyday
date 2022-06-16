package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/6/16
 */
public class N295数据流中的中位数 {
    boolean flag = false; // true 代表有奇数个节点
    Node mid = null;

    public N295数据流中的中位数() {

    }

    public void addNum(int num) {
        flag = !flag;
        Node node = new Node();
        node.val = num;
        if (mid == null){
            mid = node;
            return;
        }
        Node work = mid;
        if (num == work.val){
            node.after = work.after;
            node.before = work;
            work.after = node;
            node.after.before = node;
        }
        while(work != null){
            if (num > work.val && work.after != null){
                work = work.after;
            }else if(num < work.val && work.before != null){
                work = work.after;
            }else if(num == work.val){
                node.after = work.after;
                node.before = work;
                work.after = node;
                node.after.before = node;
            }
        }
    }

    public double findMedian() {
        if (flag == true){
            return mid.val;
        }
        return (float) (mid.val + mid.after.val) / 2.0;
    }
    class Node{
        int val;
        Node before;
        Node after;
    }
}
