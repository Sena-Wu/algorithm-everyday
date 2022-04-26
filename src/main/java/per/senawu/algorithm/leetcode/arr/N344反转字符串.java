package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/4/26
 */

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 链接：https://leetcode-cn.com/problems/reverse-string
 */
public class N344反转字符串 {
    public void reverseString(char[] s) {
        int low = 0;
        int high = s.length -1;
        while(low < high){
            char tmp = s[high];
            s[high--] = s[low];
            s[low++] = tmp;
        }

    }
}
