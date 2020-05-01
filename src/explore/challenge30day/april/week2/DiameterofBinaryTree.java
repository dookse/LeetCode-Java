package explore.challenge30day.april.week2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DiameterofBinaryTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        compute(root);
        return max;
    }

    private int compute(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = compute(node.left);
        int right = compute(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }


    @Test
    public void test0() {
        assertThat(diameterOfBinaryTree(null)).isEqualTo(0);
    }

    @Test
    public void test1() {
        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        assertThat(diameterOfBinaryTree(node)).isEqualTo(3);
    }

    @Test
    public void test2() {
        TreeNode node = new TreeNode(1);

        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.left.left = new TreeNode(5);
        node.left.left.left.left = new TreeNode(6);

        node.left.right = new TreeNode(4);
        node.left.right.right = new TreeNode(5);
        node.left.right.right.right = new TreeNode(6);

        assertThat(diameterOfBinaryTree(node)).isEqualTo(6);
    }

    @Test
    public void test3() {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.left.right = new TreeNode(2);

        assertThat(diameterOfBinaryTree(node)).isEqualTo(2);
    }


    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
