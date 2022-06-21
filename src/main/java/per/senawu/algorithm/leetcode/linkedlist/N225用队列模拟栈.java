package per.senawu.algorithm.leetcode.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Sena-wu
 * @date 2022/6/21
 */

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 链接：https://leetcode.cn/problems/implement-stack-using-queues
 */

/**
 * 入栈push: 入队que1.offer, top更新
 * 出栈pop: 将que1中除去最后一个元素,其余元素(出队 入队que2, 更新top); que1 <=> que2交换
 * top: 用一个变量记录top值, 在push时更新, 在pop时更新
 * empty(): 计算que1.size()
 */
public class N225用队列模拟栈 {
    private Deque<Integer> que1 = new LinkedList<>();
    private Deque<Integer> que2 = new LinkedList<>();
    private Integer top;
    public N225用队列模拟栈() {

    }

    public void push(int x) {
        que1.offerLast(x);
        top = x;
    }

    public int pop() {
        if(que1.size() == 1){
            top = null;
            return que1.pollFirst();
        }
        while(que1.size() > 1){
            top = que1.pollFirst();
            que2.offerLast(top);
        }
        Deque<Integer> tmp = que1;
        que1 = que2;
        que2 = tmp;
        return tmp.pollFirst();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return que1.size() == 0 ? true:false;
    }
}
