package top.elgong.binaryTree;

/**
 *  二叉树节点
 */
public class Node {

	// 为了方便，直接public
	public int value;
	public Node left = null;
	public Node right = null;

	Node(int value){
		this.value = value;
	}
}
