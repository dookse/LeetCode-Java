package explore.binarytree;

import java.util.Stack;

import org.junit.Test;

import explore.binarytree.model.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class PathSum {

    public boolean hasPathSum(final TreeNode root, final int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        stack.push(root);
        sums.push(sum);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Integer subSum = sums.pop() - node.val;
            if (node.left == null && node.right == null && subSum == 0) {
                return true;
            }
            if (node.right != null) {
                stack.push(node.right);
                sums.push(subSum);
            }
            if (node.left != null) {
                stack.push(node.left);
                sums.push(subSum);
            }
        }
        return false;
    }


    public boolean hasPathSum2(final TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        sum -= root.val;
        boolean left = hasPathSum2(root.left, sum);
        boolean right = hasPathSum2(root.right, sum);
        return left || right;
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        assertThat(hasPathSum(root, 4)).isTrue();
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        assertThat(hasPathSum(root, 11)).isTrue();
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        assertThat(hasPathSum(root, 22)).isTrue();
    }

}
