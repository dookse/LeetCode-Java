package explore.binarytree;

import java.util.Stack;

import org.junit.Test;

import explore.binarytree.model.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class MaximumDepthofBinaryTree {

    public int maxDepth(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth2(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        stack.push(root);
        depths.push(1);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            int currentDepth = depths.pop();
            if (current != null) {
                depth = Math.max(depth, currentDepth);
                stack.push(current.left);
                stack.push(current.right);
                depths.push(currentDepth + 1);
                depths.push(currentDepth + 1);
            }
        }
        return depth;
    }


    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertThat(maxDepth(root)).isEqualTo(3);
    }

}
