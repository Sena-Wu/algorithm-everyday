package per.senawu.algorithm.笔试;

import java.util.Arrays;

/**
 * @author Sena-wu
 * @date 2022/7/15
 */

/**
 * 给定字符串s, s删除完一组“BALLON”组合的7个字母后的剩余字符任然存在该组合字符，则可以继续删除
 * 问总共可以删除多少次
 * 删除时顺序不用按照“BALLOON”, 但必须是该组合,单次总共需要删除 1个“B” 1"A" 2"L" 2"0" 1"N"
 */
public class N最多删除几次 {
    public static void main(String[] args) {
        Math.min(1, 3);
        String s = "BAONXXOLL";
        solution(s);
    }
    public static int solution(String S) {
        // write your code in Java SE 8
        int[] ints = new int[5];
        for (int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            String s = String.valueOf(c);
            if ("B".equals(s)){
                ints[0] += 1;
            }else if ("A".equals(s)){
                ints[1] += 1;
            }else if ("L".equals(s)){
                ints[2] += 1;
            }else if ("O".equals(s)){
                ints[3] += 1;
            }else if ("N".equals(s)){
                ints[4] += 1;
            }
        }

        ints[2] = ints[2] / 2;
        ints[3] = ints[3] / 2;
        Arrays.sort(ints);
        return ints[0];
    }
}
