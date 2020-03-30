package explore.binarytree;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountUnivalueSubtrees {

    private int count;

    public int countUnivalSubtrees(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        isUni(root, -1);
        return count;
    }

    public boolean isUni(final TreeNode node, final int parentVal) {
        if (node == null) {
            return true;
        }
        if (!isUni(node.left, node.val) | !isUni(node.right, node.val)) {
            return false;
        }
        count++;

        return node.val == parentVal;
    }


    @Test
    public void test1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);
        assertThat(countUnivalSubtrees(root)).isEqualTo(3);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        assertThat(countUnivalSubtrees(root)).isEqualTo(4);
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(5);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(5);

        assertThat(countUnivalSubtrees(root)).isEqualTo(6);
    }


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(final int x) {
            val = x;
        }
    }
}
