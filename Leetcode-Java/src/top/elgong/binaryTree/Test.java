package top.elgong.binaryTree;

import top.elgong.binaryTree.impl.Traversal;

/**
 *   top.elgong.binaryTree.impl 中实现了 二叉树的遍历操作
 *
 *   前序，中序，后序 ，层序 的递归和迭代版本
 *
 */
public class Test {

	public static void main(String[] args) {
		
		//  建立树结构
		Node n1 = new Node(10);
		Node n2 = new Node(6);
		Node n3 = new Node(14);
		Node n4 = new Node(4);
		Node n5 = new Node(8);
		Node n6 = new Node(12);
		Node n7 = new Node(16);
		Node n8 = new Node(17);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		
		
		Traversal printTree = new Traversal();

//		System.out.println("\n前序- 递归");
//		printTree.preOrderByRecursion(n1);

		System.out.println("\n前序- 迭代");
		printTree.preOrderByIteration(n1);

//		System.out.println("\n中序- 递归");
//		printTree.midOrderByRecursion(n1);
//
//		System.out.println("\n中序- 迭代");
//		printTree.midOrderByIteration(n1);
//
//
//		System.out.println("\n后序- 递归");
//		printTree.postOrderByRecursion(n1);
//
//		System.out.println("\n后序- 迭代- 利用前序遍历实现");
//		printTree.postOrderByIteration_pre(n1);
//
//		System.out.println("\n后序- 迭代- ---");
//		printTree.postOrderByIteration(n1);
//
//
//		System.out.println("\n层序- 递归");
//		printTree.layerOrderByRecursion(n1);
//
//		System.out.println("\n层序- 迭代");
//		printTree.layerOrderByIteration(n1);

	}
}
