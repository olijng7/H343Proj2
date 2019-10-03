//////////////////////////////////////////////////////////////////////
//
// H343
// Prof. Siek
// Project 2: Segment Intersection
// Group Members: Heoliny, Joe, Rafael
//
//////////////////////////////////////////////////////////////////////

import java.util.function.BiPredicate; //what is this?

/**
 * TODO: This is your second major task.
 * <p>
 * This class implements a height-balanced binary search tree,
 * using the AVL algorithm. Beyond the constructor, only the insert()
 * and remove() methods need to be implemented. All other methods are unchanged.
 */

public class AVLTree<K> extends BinarySearchTree<K> {

    /**
     * Creates an empty AVL tree as a BST organized according to the
     * lessThan predicate.
     */
    public AVLTree(BiPredicate<K, K> lessThan) {
        super(lessThan);
    }

    /**
     * TODO
     * Inserts the given key into this AVL tree such that the ordering
     * property for a BST and the balancing property for an AVL tree are
     * maintained.
     */
    public Node insert(K key) {
        Node insertedNode = super.insert(key);
        Node curr = insertedNode.parent;

        while(!curr.isAVL() && curr.parent !=  null) {
            curr.updateHeight();

            if(!curr.isAVL()) {
                // rebalance
            }

            curr = curr.parent;
        }

        return null;
    }

    public void remove(K key) {
    }

    public Node rightRotate(Node x){
        if (x != null) {
            Node y = x.left;
            Node B = null;
            if (y != null) {
                B = y.right;
            }
            Node p = x.parent;
            if (x.data.equals(p.left.data)) {
                p.left = y;
                y.parent = p;
            } else {
                p.right = y;
                y.parent = p;
            }
            x.left = B;
            y.right = x;
            return x;
        }
        else {
            return null;
        }
    }

    public Node leftRotate(Node x){
        if (x != null) {
            Node y = x.right;
            Node B = null;
            if (y != null) {
                B = y.left;
            }
            Node p = x.parent;
            if (x.data.equals(p.right.data)) {
                p.right = y;
                y.parent = p;
            } else {
                p.left = y;
                y.parent = p;
            }
            x.right = B;
            y.left = x;
            return x;
        }
        else {
            return null;
        }
    }
}