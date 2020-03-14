package top.elgong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioningSplit131 {

    /*
    leetcode 131 题
思路：
    回溯， 每次切分：尝试从当前位置开始，切分长度依次增加。

time: O(N^2)
space:  O（N）

*/

    class Solution {

        private List<List<String>> Res;
        public List<List<String>> partition(String s) {

            Res = new ArrayList<>();
            List<String> res = new LinkedList<>();


            if(s==null || s.length()==0){
                return Res;
            }

            helper(s, 0, res);

            return Res;

        }


        private void helper(String s, int start, List<String> res){
            if(start >= s.length()){
                Res.add(new LinkedList<>(res));
                return;
            }

            // 切分  start ~ i;
            for(int i=start; i<s.length(); i++){
                // 如果不是回文子串
                if(!isP(s, start, i)){
                    continue;
                }
                //
                res.add(s.substring(start, i+1));  // substring 要+1
                helper(s, i+1, res);
                res.remove(res.size()-1);
            }

        }

        // 判断是否是回文子串

        private  boolean isP(String s, int start, int end){
            if(start > end || end >= s.length()){
                return false;
            }

            if(start == end){
                return true;
            }
            while(start < end){

                if(s.charAt(start) != s.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
}
