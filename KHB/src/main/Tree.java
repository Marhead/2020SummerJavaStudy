/*
* Name: Kim Hyun Bae
* Student ID#: 2017145086
*/

/*
* Do NOT use any external packages/classes.
* If you (un)intentionally use them we did not provide,
* you will get 0.
* Also do NOT use auto-import function on IDEs.
* If the import statements change, you will also get 0.
*/

import java.util.List;
import java.util.ArrayList;

public final class Tree<E> implements ITree<E> {

    public Tree(int arity) {
        /*
        * Input:
        *  + arity: max number of node's children. always positive.
        */
    }

    @Override
    public TreeNode<E> root() throws IllegalStateException {
        /*
        * Return the root node.
        * If there is no root, raise an IllegalStateException.
        */
        return null;
    }

    @Override
    public int arity() {
        /*
        * Return the max number of children its node can have
        */
        return -1;
    }

    @Override
    public int size() {
        /*
        * Return the number of nodes in this tree.
        */
        return -1;
    }

    @Override
    public boolean isEmpty() {
        /*
        * Return true if this tree is empty.
        */
        return false;
    }

    @Override
    public int height() throws IllegalStateException {
        /*
        * Return height of this tree.
        * If there are no nodes in this tree,
        * raise an IllegalStateException.
        */
        return -1;
    }

    @Override
    public TreeNode<E> add(E item) {
        /*
        * Insert the given node at the *end* of this tree and
        * return THE inserted NODE.
        * *End* means that the leftmost possible slot of
        * smallest depth of this tree.
        */
        return null;
    }

    @Override
    public void detach(TreeNode<E> node) throws IllegalArgumentException {
        /*
        * Detach the given node (and its descendants) from this tree.
        * if the node is not in this tree,
        * raise an IllegalArgumentException.
        */
    }

    @Override
    public List<E> preOrder() {
        /*
        * Return the sequence of items visited by preorder traversal.
        * If there are no nodes, return an empty list, NOT NULL.
        */
        List<E> seq = new ArrayList<>();
        return seq;
    }

    @Override
    public List<E> postOrder() {
        /*
        * Return the sequence of items visited by postorder traversal.
        * If there are no nodes, return an empty list, NOT NULL.
        */
        return null;
    }

    @Override
    public List<E> depthOrder() {
        /*
        * Return the sequence of items visited by depthorder traversal.
        * If there are no nodes, return an empty list, NOT NULL.
        */
        return null;
    }
}