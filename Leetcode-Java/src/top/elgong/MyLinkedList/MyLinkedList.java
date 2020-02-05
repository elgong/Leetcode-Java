package MyLinkedList;

import java.util.LinkedList;

/**
 * 
 * @author Misaya
 *
 *  带哨兵节点的链表
 */
public class MyLinkedList<E> {
	
	
/* 私有变量 */
	// head 哨兵节点，空值
	private Node<E> head = new Node<E>();
	
	// 链表当前长度
	private long length = 0;
	
/* 构造方法 */
	public MyLinkedList() {
		
	}
	

/* 插入元素  */	
	//  尾插
	public void add(E data) {
		
		// 1. 实例化新数据节点
		Node<E> newNode = new Node(data);
		
		// 2. 拿到链表的 head节点
		Node<E> currentNode = head;
		
		// 3. 找到链表的尾
		while(currentNode.next != null) {
			
			currentNode = currentNode.next;
		}
		
		// 4. 添加到尾部
		currentNode.next = newNode;
		
		// 5. 修改长度
		length += 1;
	}
	
	// 头插
	public void addFirst(E data) {
		
		// 1. 实例化新数据节点
		Node<E> newNode = new Node<E>(data);
		
		// 2. 新节点指向 head.next
		newNode.next = this.head.next;
		
		// 3. head.next 指向新节点
		
		this.head.next = newNode;
		
		// 4. 修改长度
		this.length += 1;
		
	}
	
/* 反转链表 */		
	// 链表反转有4种方法
	/**
	 *  1. 利用数组
	 *  2. 三指针
	 *  3. 逐次插入 head 后
	 *  4. 递归
	 */
	
	// 反转链表- 三指针反转法
	public void reverseBy3Point(Node<E> head) {
		
		// 如果链表少于两个节点，则不需要反转
//		if(this.length <= 1) {
//			return;
//		}
		// 跳过哨兵节点 head
	
		Node<E> currentNode = head.next;
		
		// 首个元素的上一个节点 为head， 所以设为null
		Node<E> preNode = null;
		
		Node<E> nextNode = null;
		
		// 当前处理的节点还不为空时
		// 逻辑有些复杂，得慢慢理清楚
		while(currentNode != null) {

			nextNode = currentNode.next;
			
			currentNode.next = preNode;
			
			preNode = currentNode;
			
			currentNode = nextNode;
		}
		// head 指向当前节点
		head.next = preNode;
	}
	
	
	// 反转链表- 递归法
	// 关键怎么记住  head
	public Node<E> reverseByRecursive(Node<E> node) {
		
		// 递归最深处，返回的就是最后一个节点
		if(node.next == null) {
			return node;
		}
		
		Node<E> newHead = reverseByRecursive(node.next);
		
		node.next.next = node;
		
		// 防止环
		node.next = null;
		
		return newHead;
	}
	
	
/* 检查是否有环 */	
	// 找环入口： 两个指针都每次移动一步，一个从起点，一个从相遇点， 则再次相遇的点为入口。
	// 快慢指针
	public boolean isLoop(Node<E> head) {
		
		// 跳过哨兵节点		
		// 快慢指针
		Node<E> slow = head.next;
		Node<E> quick = head.next;
		
		// 控制快慢
		while(quick != null && quick.next != null) {
			
			quick = quick.next.next;
			slow = slow.next;
			
			// 当快慢指针相遇，则有环。返回环的入口
			if(slow == quick) {
				System.out.println("存在环");
				return true;
			}
		}
		
		// 无环
		return false;
	}
	
	
	
	
/* 打印链表 */	
	
	// 正序打印
    public void printList() {
    	
    	// 跳过哨兵节点
        Node<E> tmp = head.next;
        
        // 遍历打印
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
    
    // 倒序打印
    // 1. 递归法
    public void printListByRecursive(Node<E> node) {
    	
    	if(node.next != null) {
    		printListByRecursive(node.next);
    	}
    	
    	System.out.println(node.data);
    }
    
    // 倒序打印
    // 2. 借助栈或者数组
    public void printListByStack() {
    	
    	// 跳过哨兵节点
        Node<E> tmp = head.next;
        
        // 辅助栈
        LinkedList stack = new LinkedList<E>();
        
        // 遍历压入堆栈
        while (tmp != null) {
        	stack.push(tmp.data);
            tmp = tmp.next;
        }
        
        // 遍历打出堆栈并打印
        while(!stack.isEmpty()) {
        	
        	System.out.println(stack.pop());
        }
        
    }
    
    
    
    public long length() {
    	
    	return this.length;
    }
    
    public Node<E> getHead(){
    	
    	return this.head;
    }
    
    

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/* 内部节点类 */
	class Node<E>{
		
		Node<E> next = null;
		
		E data = null;
		
		private Node(E e) {
			this.data = e;
		}
		
		private Node() {
		}
	}

}
