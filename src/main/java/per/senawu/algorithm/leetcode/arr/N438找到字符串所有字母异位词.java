package per.senawu.algorithm.leetcode.arr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Sena-wu
 * @date 2022/5/3
 */

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 */

/**
 * 滑动窗口
 */
public class N438找到字符串所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        // 左闭右开
        int left = 0;
        int right = 0;

        HashMap<Character, Integer> need = new HashMap();
        for (int i = 0; i < p.length(); i++){
            char a = p.charAt(i);
            need.put(a, need.getOrDefault(a, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap();

        List<Integer> result = new ArrayList(5);
        int have = 0;
        int length = p.length();
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))){
                    have++;
                }
            }

            if (right - left == length){
                if(have == need.size()){
                    result.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        have--;
                    }
                    window.put(d, window.get(d) - 1);
                }

            }

            // while(have == need.size()){
            //     if(have == need.size()){
            //         result.add(left);
            //     }
            //     char d = s.charAt(left);
            //     left++;
            //     if (need.containsKey(d)){
            //         if(need.get(d).equals(window.get(d))){
            //             have--;
            //         }
            //         window.put(d, window.get(d) - 1);
            //     }
            // }
        }
        return result;
    }
}
