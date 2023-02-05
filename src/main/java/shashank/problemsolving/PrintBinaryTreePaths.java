package shashank.problemsolving;

import java.util.ArrayList;
import java.util.List;


public class PrintBinaryTreePaths {

    // Leetcode 257 - Given the root of a binary tree, return all root-to-leaf paths in any order. A leaf is a node with no children.

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        String current = "" + root.val;
        findPaths(root, list, current);
        return list;
    }

    public static void findPaths(TreeNode root, List<String> list, String current) {
        if (root.left == null && root.right == null) {
            list.add(new String(current));
            return;
        }
        if (root.left != null)
            findPaths(root.left, list, current + "->" + root.left.val);
        if (root.right != null)
            findPaths(root.right, list, current + "->" + root.right.val);
    }
}

