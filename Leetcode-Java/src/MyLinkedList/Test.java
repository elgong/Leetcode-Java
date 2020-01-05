package MyLinkedList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyLinkedList<Integer> link = new MyLinkedList<Integer>();
		
		for(int i=0; i<10; i++) {
			link.add(i);
		}
		
		// 从节点头部插入
		link.addFirst(11);
		
		// 正序打印
		System.out.println("正序打印：");
		link.printList();
		
		// 倒序打印 -递归
		System.out.println("倒序打印 by 递归：");
		link.printListByRecursive(link.getHead().next);
		
		// 倒序打印 - 辅助栈
		System.out.println("倒序打印 by 辅助栈：");
		link.printListByStack();
		
		
		// 反转链表
		System.out.println("反转后的链表：");
		//link.reverseBy3Point(link.getHead());
		link.getHead().next = link.reverseByRecursive(link.getHead().next);
		System.out.println("-----");
		link.printList();
		
		// 判断是否有环
		System.out.print("无环？ ");
		System.out.println(link.isLoop(link.getHead())==null);
	}
}
