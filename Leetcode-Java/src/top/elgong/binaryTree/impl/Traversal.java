package top.elgong.binaryTree.impl;

import top.elgong.binaryTree.ITraversal;
import top.elgong.binaryTree.TreeNode;

import java.util.*;

public class Traversal implements ITraversal {

    /**
     *  前序遍历------递归版本
     * @param root
     */
    @Override
    public void preOrderByRecursion(TreeNode root) {

        if(root != null){
            System.out.print(root.value + " ");

            // 递归左节点
            preOrderByRecursion(root.left);

            // 递归右节点
            preOrderByRecursion(root.right);
        }
    }

    /**
     *  前序遍历迭代版本
     * @param root
     */
    @Override
    public void preOrderByIteration(TreeNode root) {
        if(root == null){
            return ;
        }

        Stack<TreeNode> stack = new Stack<>();

        // 模拟堆栈
        while(root != null || !stack.isEmpty()){

            // 沿着左节点遍历, 直到root为空
            while(root != null){
                System.out.print(root.value + " ");
                stack.push(root);
                /**
                 *  // 判断是否左叶子,需要从左叶子的父节点开始下手，不然不知道左右。。。
                 *  //  left NOT NULL，并且left 没有子节点，那么就是左叶子
                 * */
//                if(root.left !=null && root.left.left==null && root.left.right==null){
//                    System.out.println("左叶子 " + root.left.value);
//                }
//
//                if(root.right != null && root.right.left==null && root.right.right==null){
//                    System.out.println("右叶子 " + root.right.value);
//                }

                root = root.left;
            }

            if(!stack.isEmpty()){
                // 因为root节点已经是空值了， 所以弹出root的父节点，找到
                // 父节点的右节点，继沿着左边遍历
                root = stack.pop().right;

            }

        }
    }

    @Override
    public void midOrderByRecursion(TreeNode root) {

        if(root != null){
            midOrderByRecursion(root.left);
            System.out.print(root.value + " ");
            midOrderByRecursion(root.right);
        }
    }

    @Override
    public void midOrderByIteration(TreeNode root) {

        if(root == null){
            return ;
        }

        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()){

            while(root != null){
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                root = stack.pop();
                System.out.print(root.value + " ");
                root = root.right;
            }
        }
    }

    @Override
    public void postOrderByRecursion(TreeNode root) {
        if(root != null){
            postOrderByRecursion(root.left);

            postOrderByRecursion(root.right);

            System.out.print(root.value + " ");
        }
    }

    @Override
    public void postOrderByIteration(TreeNode root) {
        /**
         *  思路：
         *      同前序遍历一致
         *          切换 root时，要判断是从左节点，还是右节点返回的。
         *              借助last 记录上次右节点
         */

        if(root == null){
            return ;
        }
        Stack<TreeNode> s = new Stack<>();

        // 记住上一次的节点
        TreeNode last = null;
        while(root != null || !s.isEmpty()){

            // 遍历处所有的左节点
            while(root != null){
                s.push(root);
                root = root.left;
            }

            // 不能提前弹出 root
            TreeNode tmp = s.peek();
            if(!s.isEmpty()){
                // 如果没有右节点或者上次已经处理过右节点， 则处理当前栈顶
                if(tmp.right == null || last == tmp.right){
                    root = s.pop();
                    System.out.print(root.value + " ");
                    last = root;

                    root = null;

                }else{
                    root = tmp.right;
                }
            }
        }
    }

    @Override
    public void postOrderByIteration_pre(TreeNode root) {
            if(root == null){
                return ;
            }

            LinkedList<Integer> res = new LinkedList<>();
            Stack<TreeNode> s = new Stack<>();

            while(root != null || !s.isEmpty()){

                while(root != null){
                    res.addFirst(root.value);
                    s.push(root);
                    root = root.right;
                }

                if(!s.isEmpty()){
                    root = s.pop();
                    root = root.left;
                }
            }


            // 打印出来
        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i) +" ");
        }

    }

    @Override
    public void layerOrderByRecursion(TreeNode root) {
        /**
         *  层序遍历的递归版本
         *  借助List和层深度，记住每个层的元素
         */
        // 记录结果的list
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return ;
        }
        helper(root, res, 0);

        // 打印
        for(int i=0; i<res.size(); i++){
            System.out.print("layer" + i + "  :" );
            for(int j=0; j<res.get(i).size(); j++){
                System.out.print( res.get(i).get(j) + " ");
            }
        }
    }
    public static void helper(TreeNode root, List<List<Integer>> res, int depth ){
        // 如果层深度> 当前最大层深度，则创建下一层的list
        if(depth >= res.size()){
            res.add(new ArrayList<>());
        }

        // 将节点加入对应的层
        res.get(depth).add(root.value);

        // 递归
        if(root.left != null){
            helper(root.left, res, depth+1);
        }

        if(root.right != null){
            helper(root.right, res, depth+1);
        }

    }

    @Override
    public void layerOrderByIteration(TreeNode root) {
        /**
         *  层遍历- 通过迭代的方法
         *
         *      思路：  辅助队列 记住下一层的节点
         *
         */

        // 输入验证
        if(root == null){
            return ;
        }
        
        int depth = 0;
        Deque<TreeNode> deq = new LinkedList<>();

        deq.add(root);
        while(!deq.isEmpty()){

            int layer_size = deq.size();

            System.out.print("layer" + depth + " ");

            for(int i=0; i<layer_size; i++){
                TreeNode tmp = deq.poll();
                System.out.print(tmp.value + " ");
                if(tmp.left != null){
                    deq.add(tmp.left);
                }

                if(tmp.right != null){
                    deq.add(tmp.right);
                }
            }

            // 记住层数
            depth++;
        }
    }
}
