package explore.binarytree;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import explore.binarytree.model.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    private int preIndex = -1;
    private int[] preorder;
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(final int[] preorder, final int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildNode(0, preorder.length);
    }

    private TreeNode buildNode(final int left, final int right) {
        if (left == right) {
            return null;
        }
        preIndex++;
        int value = preorder[preIndex];
        int index = indexMap.get(value);

        TreeNode node = new TreeNode(value);
        node.left = buildNode(left, index);
        node.right = buildNode(index + 1, right);

        return node;
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 1, 3};
        assertThat(buildTree(preorder, inorder)).isEqualTo(root);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        assertThat(buildTree(preorder, inorder)).isEqualTo(root);
    }

}
