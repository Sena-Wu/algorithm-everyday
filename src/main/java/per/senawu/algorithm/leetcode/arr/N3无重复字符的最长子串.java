package per.senawu.algorithm.leetcode.arr;

import java.util.HashMap;

/**
 * @author Sena-wu
 * @date 2022/5/4
 */

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */

/**
 * 滑动窗口
 */
public class N3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        // 左闭右开
        int left = 0;
        int right = 0;

        HashMap<Character, Integer> window = new HashMap();
        int max = 0;
        // flag==true window中无重复字符
        boolean flag = true;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c) > 1){
                flag = false;
            }

            // window中无重复字符
            if (flag){
                if (right - left > max){
                    max = right -left;
                }
            }

            // window中有重复字符
            while (!flag){
                char d = s.charAt(left);
                left++;
                if (window.get(d).equals(2)){
                    flag = true;
                }
                window.put(d, window.get(d) - 1);
            }
        }
        return max;
    }
}
