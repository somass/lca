package com.f5.lca.tree;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeNodeTest {
    /**
     *  null
     */

    @Test
    public void testGetLCA_null() {
        Assert.assertNull(BinaryTreeNode.getLca(null, null));
    }

    /**
     *              1
     *           /    \
     *          6      5
     *         /
     *        3
     *
     *        1 is the lca for 3, 5
     */
    @Test
    public void testGetLca_rootAsParent() {
        BinaryTreeNode root = new BinaryTreeNode(null, 1);

        BinaryTreeNode node6 = new BinaryTreeNode(root, 6);
        root.setLeft(node6);
        BinaryTreeNode node5 = new BinaryTreeNode(root, 5);
        root.setLeft(node5);

        BinaryTreeNode node3 = new BinaryTreeNode(node6, 3);
        node6.setLeft(node3);

        Assert.assertEquals(root, BinaryTreeNode.getLca(node3, node5));
    }

    /**
     *              1
     *           /    \
     *          6       5
     *                 /  \
     *                9    4
     *                     \
     *                     11
     *
     *        4 is the lca for 4, 11
     */
    @Test
    public void testGetLca_oneNodeIsParent() {
        BinaryTreeNode root = new BinaryTreeNode(null, 1);

        BinaryTreeNode node6 = new BinaryTreeNode(root, 6);
        root.setLeft(node6);
        BinaryTreeNode node5 = new BinaryTreeNode(root, 5);
        root.setLeft(node5);

        BinaryTreeNode node9 = new BinaryTreeNode(node5, 9);
        node5.setLeft(node9);

        BinaryTreeNode node4 = new BinaryTreeNode(node5, 4);
        node5.setLeft(node4);

        BinaryTreeNode node11 = new BinaryTreeNode(node4, 11);
        node4.setRight(node11);

        Assert.assertEquals(node5, BinaryTreeNode.getLca(node4, node5));
    }


    /**
     *              1
     *           /    \
     *          6      5
     *         / \
     *        3   8
     *       /
     *      12
     *
     *        6 is the lca for 12, 8
     */
    @Test
    public void testGetLca_bothNodesLeftSide() {
        BinaryTreeNode root = new BinaryTreeNode(null, 1);

        BinaryTreeNode node6 = new BinaryTreeNode(root, 6);
        root.setLeft(node6);
        BinaryTreeNode node5 = new BinaryTreeNode(root, 5);
        root.setLeft(node5);

        BinaryTreeNode node3 = new BinaryTreeNode(node6, 3);
        node6.setLeft(node3);

        BinaryTreeNode node12 = new BinaryTreeNode(node3, 12);
        node6.setLeft(node3);

        BinaryTreeNode node8 = new BinaryTreeNode(node6, 8);
        node6.setRight(node8);

        Assert.assertEquals(node6, BinaryTreeNode.getLca(node12, node8));
    }

    /**
     *              1
     *
     *        1 is the lca for 1, 1
     */
    @Test
    public void testGetLca_sameNode() {
        BinaryTreeNode root = new BinaryTreeNode(null, 1);

        Assert.assertEquals(root, BinaryTreeNode.getLca(root, root));
    }

    /**
     *              1
     *
     *        1 is the lca for 1, null
     */
    @Test
    public void testGetLca_oneNodeNull() {
        BinaryTreeNode root = new BinaryTreeNode(null, 1);

        Assert.assertEquals(root, BinaryTreeNode.getLca(root, null));
    }
}
