package com.leetcode.solutions.BinaryTree;
import com.leetcode.solutions.BinaryTree.Solution.TreeNode;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        LevelOrderTraversal obj = new LevelOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        obj.getLevelOrder(root);

    }
    public void getLevelOrder(TreeNode root) {
        if(root == null)
            return ;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int count = queue.size();
            for(int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                System.out.print(" " + node.val + " ");
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            System.out.println();
        }
    }
}
