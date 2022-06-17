package per.senawu.algorithm.leetcode.linkedlist;

/**
 * @author Sena-wu
 * @date 2022/6/16
 */
public class N295数据流中的中位数 {
    boolean flag = false; // true 代表有奇数个节点
    Node mid = null;  // 偶数个节点时，表示第一个中位数

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
        if(num >= work.val){
            while (work.after != null && num > work.after.val){work = work.after;}
            node.after = work.after;
            node.before = work;
            work.after = node;
            if (node.after != null){node.after.before = node;}
            mid = flag == true ? mid.after: mid;
        }else{
            while (work.before != null && num < work.before.val){work = work.before;}
            node.before = work.before;
            node.after = work;
            work.before = node;
            if (node.before != null){node.before.after = node;}
            mid = flag == true ? mid: mid.before;
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
