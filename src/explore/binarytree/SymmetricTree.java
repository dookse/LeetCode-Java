package explore.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import explore.binarytree.model.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SymmetricTree {

    public boolean isSymmetric(final TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(final TreeNode left, final TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        boolean leftMirror = isMirror(left.left, right.right);
        boolean rightMirror = isMirror(left.right, right.left);
        return left.val == right.val && leftMirror && rightMirror;
    }

    public boolean isSymmetric2(final TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            } else if (left == null || right == null) {
                return false;
            } else if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        assertThat(isSymmetric(root)).isTrue();
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        assertThat(isSymmetric(root)).isFalse();
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(3);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = null;
        root.right.right = new TreeNode(4);

        assertThat(isSymmetric(root)).isFalse();
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(2);
        root.right.left.left = new TreeNode(2);
        root.right.left.right = new TreeNode(1);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        assertThat(isSymmetric(root)).isTrue();
    }

}
