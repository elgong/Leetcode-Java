package top.elgong.leetcode;

import java.util.LinkedList;

/**
 *  leetcode 682
 * @author Misaya
 *  
 *  借助堆栈实现
 *  
 *  也可以借助 数组+ 位置控制变量实现堆栈的功能
 */
public class BaseBallGame682 {

	public static void main(String[] args) {
		
		// 输入值
		String[] input = {"5","2","C","D","+"};
		// 正确答案
		int trueRes = 30;
		
		Solution so = new Solution();
		int res = so.calPoints(input);
		
		System.out.println("正确答案为：  " + trueRes );
		System.out.println("程序计算为：  " + res);
		
	}

}


class Solution {
    public int calPoints(String[] ops) {

        // 需要借助栈
        LinkedList<Integer> stack = new LinkedList<Integer>();

        // 将有效成绩逐个压入堆栈
        for(int i=0; i<ops.length; i++){
            String str = ops[i];
            switch(str){
                case "+":{
                    int tmp = stack.pop();
                    int score = tmp + (int)stack.peek();
                    stack.push(tmp);
                    stack.push(score);
                    break;
                }

                case "D":{
                    int score = (int)stack.peek()*2;
                    stack.push(score);
                    break;
                }

                case "C":{
                    stack.pop();
                    break;
                }
                default:{
                    stack.push(Integer.valueOf(str));
                    break;
                }
            }
        }

        // 从堆栈中获取有效成绩
        int res = 0;
        while(stack.size() != 0){
            res += (int)stack.pop();
        }
        return res;
    }
}