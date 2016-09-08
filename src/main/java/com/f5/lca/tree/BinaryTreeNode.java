package com.f5.lca.tree;

import lombok.Data;

/**
 *  space complexity O(1) - doesn't change with input changes
 *  time complexity O(n)
 *
 */

@Data
public class BinaryTreeNode {
    private BinaryTreeNode parent;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private int data;

    public BinaryTreeNode(BinaryTreeNode parent, int data) {
        this.parent = parent;
        this.data = data;
    }

    public String toString() {
        return "Node with data: "+ data;
    }

    public static BinaryTreeNode getLca(BinaryTreeNode node1, BinaryTreeNode node2) {
        if(node1 == null && node2 == null) {
            return null;
        }

        if(node1 == node2) {
            return node1;
        }

        while(node1 != null && node2 != null) {

            if(isNode1ParentOfNode2(node1, node2)) {
                return node1;
            }

            if(isNode1ParentOfNode2(node2, node1)) {
                return node2;
            }

            if(node1.getParent() == node2.getParent()) {
                return node1.getParent();
            }

            node1 = node1.getParent();
            node2 = node2.getParent();
        }

        return node1 == null? node2 : node1;
    }

    private static boolean isNode1ParentOfNode2(BinaryTreeNode node1, BinaryTreeNode node2) {
        return node1 != null && node2.getParent() != null && node1.getData() == node2.getParent().getData();
    }

}
