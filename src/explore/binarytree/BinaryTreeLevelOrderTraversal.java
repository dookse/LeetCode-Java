package explore.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

import explore.binarytree.model.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(final TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            bfs(root, 0, result);
        }
        return result;
    }

    private void bfs(final TreeNode node, final int level, final List<List<Integer>> result) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        if (node.left != null) {
            bfs(node.left, level + 1, result);
        }
        if (node.right != null) {
            bfs(node.right, level + 1, result);
        }
    }

    public List<List<Integer>> levelOrder2(final TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelNodes = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current == null) {
                    continue;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                levelNodes.add(current.val);
            }
            result.add(levelNodes);
        }
        return result;
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertThat(levelOrder(root)).isEqualTo(List.of(
            List.of(3),
            List.of(9, 20),
            List.of(15, 7)
        ));
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
        assertThat(levelOrder(root)).isEqualTo(List.of(
            List.of(1),
            List.of(2, 3),
            List.of(4, 5, 6, 7)
        ));
    }

}
