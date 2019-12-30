package top.elgong.leetcode;

import java.util.Stack;


/**
 * 
 * @author Misaya
 *   利用栈实现队列的功能： add, remove, isEmpty, peek
 *   
 *   主要解决push 问题( 借助辅助栈)
 */
public class ImplQueueByStack {


	public static void main(String[] args) {

		// 测试 依次压入 1,2,3
		add(1);
		add(2);
		add(3);

		System.out.println(remove());
		System.out.println(remove());
		System.out.println(remove());


	}
	
	private static Stack stack = new Stack<Integer>();
	private static Stack assistStack = new Stack<Integer>();
	
	public static void add(int e) {
		
		// 搞清楚顺序。
		// 1. 先将 主栈元素压入辅助栈
		while(stack.size() != 0) {
			assistStack.push(stack.pop());
		}
		
		// 2. 后进的元素压入主栈栈底
		stack.push(e);
		
		// 3. 辅助栈弹出来压入主栈
		while(assistStack.size() != 0) {
			stack.push(assistStack.pop());
		}
		
	}
	
	
	public static int remove() {
		return (int) stack.pop();
	}
	
	
	public static int peek() {
		
		return (int) stack.peek();
	}

}
