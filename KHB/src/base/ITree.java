import java.util.List;

public interface ITree<E> {
    /*
    * Return the root node.
    * If there is no root, raise an IllegalStateException.
    */
    TreeNode<E> root() throws IllegalStateException;

    /*
    * Return the number of childrens that each node can have
    */
    int arity();

    /*
    * Return the number of nodes in this tree.
    */
    int size();

    /*
    * Return true if this tree has no nodes.
    */
    boolean isEmpty();

    /*
    * Return the height of this tree.
    * If there is no root, raise an IllegalStateException.
    */
    int height() throws IllegalStateException;

    /*
    * Insert the item at the *end* of this tree and
    * return THE inserted NODE.
    * *End* means that the uppermost, rightmost possible slot of this tree.
    * The node is always a single node (has no children).
    */
    TreeNode<E> add(E item);

    /*
    * Detach the given node from the tree.
    * If the node does not belong to the tree,
    * raise an IllegalStateException.
    */
    void detach(TreeNode<E> node) throws IllegalArgumentException;

    /*
    * Return the sequence of visited items in preorder traversal
    */
    List<E> preOrder();

    /*
    * Return the sequence of visited items by postorder traversal
    */
    List<E> postOrder();

    /**
     * Return the sequence of visited items by depthorder traversal
     */
    List<E> depthOrder();
}