package explore.binarytree.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int x) {
        val = x;
    }
}
