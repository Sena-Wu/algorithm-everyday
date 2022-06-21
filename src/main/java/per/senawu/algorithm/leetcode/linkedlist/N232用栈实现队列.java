package per.senawu.algorithm.leetcode.linkedlist;

import java.util.LinkedList;

/**
 * @author Sena-wu
 * @date 2022/6/21
 */

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 * 链接：https://leetcode.cn/problems/implement-queue-using-stacks
 */
/**
 * 入队push: 栈为空更新peek, 入栈stack1.push
 * 出队pop: 将stack1中除去最后一个元素,其余元素(出栈 入栈stack2); 保存stack1栈底元素; 更新peek为 stack2.peek; stack1中全部元素(出栈 入栈stack1)
 * peek: 用一个变量记录peek值, 在push时更新, 在pop时更新
 * empty(): 计算stack1.size()
 */
public class N232用栈实现队列 {
    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<Integer> stack2 = new LinkedList<>();
    private Integer peek;
    public N232用栈实现队列() {

    }

    public void push(int x) {
        if (stack1.size() == 0){
            peek = x;
        }
        stack1.push(x);
    }

    public int pop() {
        if(stack1.size() == 1){
            peek = null;
            return stack1.pop();
        }
        while(stack1.size() > 1){
            stack2.push(stack1.pop());
        }
        int result = stack1.pop();
        peek = stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public int peek() {
        return peek;
    }

    public boolean empty() {
        return stack1.size() == 0 ? true:false;
    }
}
