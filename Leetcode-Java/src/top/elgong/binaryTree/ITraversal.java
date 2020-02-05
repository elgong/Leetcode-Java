package top.elgong.binaryTree;

public interface ITraversal {

    // 1. 前序遍历- 递归
    void preOrderByRecursion(Node root);

    // 2. 前序遍历- 迭代
    void preOrderByIteration(Node root);

    // 3. 中序遍历- 递归
    void midOrderByRecursion(Node root);

    // 4. 中序遍历- 迭代
    void midOrderByIteration(Node root);


    // 5. 后序遍历- 递归
    void postOrderByRecursion(Node root);

    // 6. 后序遍历- 迭代-借助前序遍历
    void postOrderByIteration_pre(Node root);
    // 6. 后序遍历- 迭代-靠自己
    void postOrderByIteration(Node root);

    // 7. 层序遍历- 递归
    void layerOrderByRecursion(Node root);

    // 8. 层序遍历- 迭代
    void layerOrderByIteration(Node root);
}
