package per.senawu.algorithm.leetcode.arr;

import java.util.HashMap;

/**
 * @author Sena-wu
 * @date 2022/5/3
 */

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */

/**
 * 滑动窗口
 */
public class N76最小覆盖子串 {
    public static String minWindow(String s, String t) {
        // 左闭右开 控制window范围
        int left = 0;
        int right = 0;

        HashMap<Character, Integer> need = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            char c1 = t.charAt(i);
            need.put(c1, need.getOrDefault(c1, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap();

        int len = Integer.MAX_VALUE;
        int start = 0;
        // need中有多少个char的个数在window中被满足
        // 例：need中 a: 2; 当window中包含两个a时,  have++;
        int have = 0;

        while(right < s.length()){
            // 左闭右开 把right加入window
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 一定不能用==; 否则有测试用例不通过
                if (need.get(c).equals(window.get(c))){
                    have++;
                }
            }

            // need中的char都已满足
            while(have == need.size()){
                if ((right - left) < len){
                    len = right - left;
                    start = left;
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    // window中的d的个数刚好满足need left右移则破坏条件
                    if (window.get(d).equals(need.get(d))) {
                        have--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
