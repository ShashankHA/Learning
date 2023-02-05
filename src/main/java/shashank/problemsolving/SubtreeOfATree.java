package shashank.problemsolving;

public class SubtreeOfATree {
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
        TreeNode node26b = new TreeNode(26);
        TreeNode node3b = new TreeNode(3);
        TreeNode node3b2 = new TreeNode(3);

        node26b.left = node10b;
        node26b.right = node3b;
        node3b.right = node3b2;
        node10b.left = node4b;
        node10b.right = node6b;
        node4b.left = node30b;


        System.out.println(findIfSubtree(node10,node26b));
    }

    static boolean findIfSubtree(TreeNode subNode, TreeNode mainNode) {

        if(subNode!=null && mainNode!=null && subNode.val == mainNode.val) {
            return findIfSubtree(subNode.left,mainNode.left) && findIfSubtree(subNode.right,mainNode.right);
        }
        else if(subNode!=null && mainNode!=null && subNode.val != mainNode.val) {
            return findIfSubtree(subNode,mainNode.left) || findIfSubtree(subNode,mainNode.right);
        }
        else if(subNode !=null && mainNode == null)
            return false;
        return true;
    }
}
