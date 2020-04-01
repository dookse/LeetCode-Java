package explore.binarytree;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import explore.binarytree.model.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

    private int postIndex;
    private int[] postorder;
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(final int[] inorder, final int[] postorder) {
        this.postIndex = postorder.length;
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildNode(0, inorder.length - 1);
    }

    private TreeNode buildNode(final int left, final int right) {
        if (left > right) {
            return null;
        }
        postIndex--;

        int value = postorder[postIndex];
        int index = indexMap.get(value);

        TreeNode node = new TreeNode(value);
        node.right = buildNode(index + 1, right);
        node.left = buildNode(left, index - 1);

        return node;
    }

    @Test
    public void test1() {
        int[] inorder = new int[]{2, 1, 3};
        int[] postorder = new int[]{2, 3, 1};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        assertThat(buildTree(inorder, postorder)).isEqualTo(root);
    }

    @Test
    public void test2() {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        assertThat(buildTree(inorder, postorder)).isEqualTo(root);
    }

    @Test
    public void test3() {
        int[] inorder = new int[]{4, 2, 1, 5, 3, 6};
        int[] postorder = new int[]{4, 2, 5, 6, 3, 1};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        assertThat(buildTree(inorder, postorder)).isEqualTo(root);
    }
}
