package top.elgong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Misaya
 *   利用队列实现堆栈的功能： push， pop， peek， isEmpty
 *   
 *   主要解决push 问题( 借助临时队列)
 */
public class ImplStackByQueue {

	public static void main(String[] args) {

		// 测试 依次压入 1,2,3
		push(1);
		push(2);
		push(3);

		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
	}
	
	// 队列
	private static Queue queA = new LinkedList<Integer>();
	private static Queue assistQue = new LinkedList<Integer>();
	
	// 临时变量实现 push
	public static void push(int e) {
		
		assistQue.add(e);
		
		while(queA.size() != 0) {
			assistQue.add(queA.remove());
		}
		
		while(assistQue.size() != 0) {
			queA.add(assistQue.remove());
		}
		
	}
	
	public static int pop() {
		
		return (int)queA.remove();
	}
	
	public static boolean isEmpty() {
		
		return queA.size() == 0;
	}
	
	public static int peek() {
		
		return (int)queA.element();
	}
}
