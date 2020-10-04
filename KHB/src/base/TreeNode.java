import java.util.List;
import java.util.ArrayList;

public final class TreeNode<E> {
    private TreeNode<E> parent;
    private List<TreeNode<E>> children;
    private E value;
    private int maxChildren;

    public TreeNode(int k, E value) {
        parent = null;
        children = new ArrayList<>();
        this.value = value;
        maxChildren = k;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public TreeNode<E> getChild(int k) throws IndexOutOfBoundsException {
        /*
        * Return its k-th child. (0 <= k < #children)
        * if k is not in the valid range,
        * raise an IndexOutOfBoundsException.
        */
        return children.get(k);
    }

    public E getValue() {
        return value;
    }

    public void insertChild(int k, TreeNode<E> n) throws IndexOutOfBoundsException, IllegalStateException {
        /*
        * Insert the node n as its k-th child. (0 <= k <= #children)
        * Shift the k-th node and any subsequent nodes to the right.
        * if k is not in the valid range,
        * raise an IndexOutOfBoundsException.
        * If this node has already max number of children,
        * raise an IllegalStateException
        */
        if (children.size() == maxChildren())
            throw new IllegalStateException();
        children.add(k, n);
    }

    public TreeNode<E> removeChild(int k) throws IndexOutOfBoundsException {
        /*
        * Remove and return the k-th child node. (0 <= k < #children)
        * Shift the (k+1)-th node (if any) and its subsequent nodes
        * to the left.
        * If k is not in the valid range,
        * raise an IndexOutOfBoundsException.
        */
        return children.remove(k);
    }

    public void setValue(E v) {
        value = v;
    }

    public int numChildren() {
        /*
        * Return the number of children this node has.
        */
        return children.size();
    }

    public int maxChildren() {
        /*
        * Return the maximum number of children this node can have.
        */
        return maxChildren;
    }
}
