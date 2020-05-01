package explore.challenge30day.april.week3;

import org.junit.jupiter.api.Test;

import explore.binarytree.model.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class ConstructBinarySearchTreefromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootValue = preorder[start];
        TreeNode root = new TreeNode(rootValue);
        int i;
        for (i = start + 1; i <= end; i++) {
            if (rootValue < preorder[i]) {
                break;
            }
        }
        root.left = buildTree(preorder, start + 1, i - 1);
        root.right = buildTree(preorder, i, end);
        return root;
    }


    @Test
    public void test1() {
        TreeNode expected = new TreeNode(8);
        expected.left = new TreeNode(5);
        expected.right = new TreeNode(10);
        expected.left.left = new TreeNode(1);
        expected.left.right = new TreeNode(7);
        expected.right.right = new TreeNode(12);

        assertThat(bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12})).isEqualTo(expected);
    }

}
