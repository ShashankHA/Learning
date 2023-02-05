package shashank.problemsolving;

public class SameBinaryTree {
    public static void main(String[] args) {

        TreeNode node10 = new TreeNode(10);
        TreeNode node6 = new TreeNode(10);
        TreeNode node4 = new TreeNode(4);
        TreeNode node30 = new TreeNode(30);

        node10.left = node4;
        node10.right = node6;
        node4.left = node30;

        TreeNode node10b = new TreeNode(10);
        TreeNode node6b = new TreeNode(10);
        TreeNode node4b = new TreeNode(4);
        TreeNode node30b = new TreeNode(30);

        node10b.left = node4b;
        node10b.right = node6b;
        node4b.left = node30b;

        System.out.println(checkIfBothTreesAreSame(node10,node10b));
    }

    static boolean checkIfBothTreesAreSame(TreeNode node1, TreeNode node2) {
        if(node1 !=null && node2!=null && node1.val == node2.val){
            return checkIfBothTreesAreSame(node1.left,node2.left) && checkIfBothTreesAreSame(node1.right,node2.right);
        }
        else if(node1 == null && node2 == null){
            return true;
        }
        return false;
    }
}
