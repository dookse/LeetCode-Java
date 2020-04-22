package problems.easy;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 938. Range Sum of BST
public class P938 {

    public int rangeSumBST(final TreeNode root, final int left, final int right) {
        int sum = 0;
        if (left <= root.val && root.val <= right) {
            sum += root.val;
        }
        if (root.left != null) {
            sum += rangeSumBST(root.left, left, right);
        }
        if (root.right != null) {
            sum += rangeSumBST(root.right, left, right);
        }
        return sum;
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(10);
        assertThat(rangeSumBST(root, 7, 15)).isEqualTo(10);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);

        assertThat(rangeSumBST(root, 5, 15)).isEqualTo(20);
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right = new TreeNode(15);
        root.right.left = null;
        root.right.right = new TreeNode(18);

        assertThat(rangeSumBST(root, 1, 20)).isEqualTo(58);
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right = new TreeNode(15);
        root.right.left = null;
        root.right.right = new TreeNode(18);

        assertThat(rangeSumBST(root, 7, 15)).isEqualTo(32);
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


