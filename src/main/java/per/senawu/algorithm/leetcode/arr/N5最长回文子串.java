package per.senawu.algorithm.leetcode.arr;

import java.util.HashMap;

/**
 * @author Sena-wu
 * @date 2022/4/27
 */

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */

/**
 * 一、递归: 递归返回字符串最长回文子串的index范围work(s, low, high)
 *      1、work(s, low+1, high-1) 判断s[low] == s[high]
 *      2、work(s, low+1, high)
 *      3、work(s, low, high-1)
 *      4、根据1、2、3得到s在(low, high)的最长回文子串index范围
 * 二、中心扩展:
 *      以字符串中的任一一个或两个字符为回文子串的中心点, 以该字符为中心向两端扩张寻找最长回文子串
 */
public class N5最长回文子串 {
    // 中心扩展
    // 最长回文子串长度
    int max = 0;
    // 最长子串的首尾index
    int[] result = new int[]{0, 0};
    public String longestPalindrome(String s) {

        char[] toarray = s.toCharArray();
        for(int i = 0; i < s.length() -1; i++){
            // 以 i 为中心的奇数长度回文串
            oneCenter(toarray, i);
            // 以 i i+1 为中心点的偶数长度回文串
            twoCenter(toarray, i);
        }
        return s.substring(result[0], result[1] + 1);
    }
    void oneCenter(char[] s, int i){
        int low = i;
        int high = i;
        while(low >= 0 && high < s.length){
            if (s[low] == s[high]){
                low--;
                high++;
            }else{
                break;
            }
        }
        if (high - low -1 > max){
            max = high - low -1;
            result = new int[]{low+1, high-1};
        }
    }
    void twoCenter(char[] s, int i){
        int low = i;
        int high = i+1;
        while(low >= 0 && high < s.length){
            if (s[low] == s[high]){
                low--;
                high++;
            }else{
                break;
            }
        }
        if (high - low - 1 > max){
            max = high - low -1;
            result = new int[]{low+1, high-1};
        }
    }

    // 递归版
    HashMap<String, int[]> memo;
    public String _longestPalindrome(String s) {
        memo = new HashMap();
        char[] tochar = s.toCharArray();
        int[] sub = work(tochar, 0, s.length()-1);
        return s.substring(sub[0], sub[1]+1);
    }

    int[] work(char[] s, int low, int high){
        if (low == high || low == high -1 && s[high] == s[low]){
            return new int[]{low, high};
        }
        if (low > high){
            return new int[]{-1, -2};
        }

        int[] sub1 = memo.getOrDefault("_" + (low+1) + "_" + (high-1), null) != null ? memo.get("_" + (low+1) + "_" + (high-1)) : work(s, low+1, high-1);
        if (s[low] == s[high] && sub1[0] == low+1 && sub1[1] == high-1){
            memo.put("_" + low + "_" + high, new int[]{low, high});
            return new int[]{low, high};
        }

        int[] sub2 = memo.getOrDefault("_" + (low+1) + "_" + (high), null) != null ? memo.get("_" + (low+1) + "_" + (high)) : work(s, low+1, high);
        int[] sub3 = memo.getOrDefault("_" + (low) + "_" + (high-1), null) != null ? memo.get("_" + (low) + "_" + (high-1)) : work(s, low, high-1);
        int[] max = (sub2[1] -sub2[0]) > (sub3[1] -sub3[0]) ? sub2 : sub3;
        max = (sub1[1] -sub1[0]) > (max[1] -max[0]) ? sub1 : max;
        memo.put("_" + (low) + "_" + (high), max);
        return max;
    }
}
