package top.elgong.binaryTree;

public interface ITraversal {

    // 1. 前序遍历- 递归
    void preOrderByRecursion(TreeNode root);

    // 2. 前序遍历- 迭代
    void preOrderByIteration(TreeNode root);

    // 3. 中序遍历- 递归
    void midOrderByRecursion(TreeNode root);

    // 4. 中序遍历- 迭代
    void midOrderByIteration(TreeNode root);


    // 5. 后序遍历- 递归
    void postOrderByRecursion(TreeNode root);

    // 6. 后序遍历- 迭代-借助前序遍历
    void postOrderByIteration_pre(TreeNode root);
    // 6. 后序遍历- 迭代-靠自己
    void postOrderByIteration(TreeNode root);

    // 7. 层序遍历- 递归
    void layerOrderByRecursion(TreeNode root);

    // 8. 层序遍历- 迭代
    void layerOrderByIteration(TreeNode root);
}
