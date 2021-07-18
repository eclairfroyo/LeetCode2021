package com.leetcode.solutions.BinaryTree;
import com.leetcode.solutions.BinaryTree.Solution.TreeNode;
import java.util.Deque;
import java.util.ArrayDeque;

//1008. Construct Binary Search Tree from Preorder Traversal
public class BSTfromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if(n == 0) return null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for(int idx = 1; idx < n; idx++){
            TreeNode node = stack.peek();
            TreeNode child = new TreeNode(preorder[idx]);

            while(!stack.isEmpty() && child.val > stack.peek().val)
                node = stack.pop();
            if(child.val > node.val)
                node.right = child;
            else
                node.left = child;
            stack.push(child);
        }
        return root;
    }
    public static void main(String[] args) {
        BSTfromPreorder obj = new BSTfromPreorder();
        LevelOrderTraversal printObj = new LevelOrderTraversal();

        System.out.println("testcase 1 results : ");
        int[] input1 = new int[] {8,5,1,7,10,12};
        TreeNode root = obj.bstFromPreorder(input1);
        printObj.getLevelOrder(root);

        System.out.println("testcase 2 results : ");
        int[] input2 = new int[] {1,3};
        root = obj.bstFromPreorder(input2);
        printObj.getLevelOrder(root);

    }
}


