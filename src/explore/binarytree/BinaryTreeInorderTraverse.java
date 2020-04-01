package explore.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import explore.binarytree.model.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeInorderTraverse {

    public List<Integer> inorderTraversal(final TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    public List<Integer> inorderTraversal2(final TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(result, root);
        return result;
    }

    private void inorder(final List<Integer> result, final TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(result, root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            inorder(result, root.right);
        }
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        assertThat(inorderTraversal(root)).isEqualTo(Arrays.asList(1, 3, 2));
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
        assertThat(inorderTraversal(root)).isEqualTo(Arrays.asList(4, 2, 5, 1, 6, 3, 7));
    }
}

