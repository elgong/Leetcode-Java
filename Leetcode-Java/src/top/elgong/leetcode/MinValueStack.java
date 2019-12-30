package top.elgong.leetcode;

import java.util.LinkedList;
import java.util.Stack;


/***
 *  
 * @author Misaya
 *  
 *  leetcode-115 最小栈
 *  
 *  解决思路：
 *  	需要能够记住每个状态时的最小值， 当最小值发生变化，可以通过压入堆栈来记录。
 *  遇到问题： 
 *  	1. 注意处理压入值等于当前最小值的情况。
 */
public class MinValueStack {


	public static void main(String[] args) {
		
		// 压入 
		for(int i=10; i>=0; i--) {
			System.out.println("压入：  " + i);
			push(i);
			System.out.println("最小值： " + getMin()+ "\n");
		}
		
		
		// 弹出
		for(int i=0; i<=10; i++) {
			
			System.out.println("弹出： " + pop());
			System.out.println(getMin());
		}
	}
	
	private  static Stack stack = new Stack<Integer>();
	
	private static int min = Integer.MAX_VALUE;
	
	public static void push(int e) {
		
		// 如果是当前最小值， 则压入堆栈
		// 注意 压入值恰好等于最小值的情况。
		if(e <= min) {
			
			stack.push(min);
			min = e;
		}
		
		// 压入新元素
		stack.push(e);
	}
	
	public static int pop() {
		
		// 转换类型
		int val = (int)stack.pop();
		if(val == min) {
			min = (int)stack.pop();
		}
		return val;
	}
	
	public static int peek() {
		return (int)stack.peek();
	}
	
	
	public static int getMin() {
		return min;
	}

}
