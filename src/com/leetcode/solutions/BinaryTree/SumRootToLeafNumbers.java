package com.leetcode.solutions.BinaryTree;
//Leetcode 129. Sum Root to Leaf Numbers
class Solution {
    int result = 0;
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int sumNumbers(TreeNode root) {
        getPathValue(root, 0);
        return result;
    }
    public void getPathValue(TreeNode root, int pathValue) {
        if(root == null)
            return;

        pathValue *= 10;
        pathValue += root.val;

        if(root.left == null && root.right == null)
            result += pathValue;

        getPathValue(root.left, pathValue);
        getPathValue(root.right, pathValue);
    }
    public static void main(String[] args) {

        TreeNode node = new TreeNode(9);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(5);
        node.right = new TreeNode(4);
        node.right.right = new TreeNode(6);

        Solution obj = new Solution();
        System.out.println("Sum of paths is " + obj.sumNumbers(node));
    }
}
