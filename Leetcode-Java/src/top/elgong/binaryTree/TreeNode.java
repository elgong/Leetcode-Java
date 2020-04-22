package top.elgong.binaryTree;

/**
 *  二叉树节点
 */
public class TreeNode {

	// 为了方便，直接public
	public int value;
	public TreeNode left = null;
	public TreeNode right = null;

	TreeNode(int value){
		this.value = value;
	}
}
