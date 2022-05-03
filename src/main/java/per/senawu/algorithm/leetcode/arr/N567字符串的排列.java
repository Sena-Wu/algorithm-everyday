package per.senawu.algorithm.leetcode.arr;

/**
 * @author Sena-wu
 * @date 2022/5/3
 */
import java.util.HashMap;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 *
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 */

/**
 * 滑动窗口 窗口大小固定
 */
public class N567字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0;
        int right = 0;

        HashMap<Character, Integer> need = new HashMap();
        for (int i = 0; i < s1.length(); i++){
            char c1 = s1.charAt(i);
            need.put(c1, need.getOrDefault(c1, 0) + 1);
        }
        HashMap<Character, Integer> window = new HashMap();

        int start = 0;
        int have = 0;
        int length = s1.length();

        while(right < s2.length()){
            char c = s2.charAt(right);
            right++;

            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))){
                    have++;
                }
            }

            // 二者取其一即可
            // 1、window长度不固定进行判断
            while(have == need.size()){
                if (right - left == length){
                    return true;
                }

                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)){
                    if (need.get(d).equals(window.get(d))){
                        have--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }

            // 2、控制window的长度为length后进行判断
            // if(right - left == length){
            //     if (have == need.size()){
            //         return true;
            //     }

            //     char d = s2.charAt(left);
            //     left++;
            //     if (need.containsKey(d)){
            //         if (need.get(d).equals(window.get(d))){
            //             have--;
            //         }
            //         window.put(d, window.get(d)-1);
            //     }

            // }

        }
        return false;
    }
}
