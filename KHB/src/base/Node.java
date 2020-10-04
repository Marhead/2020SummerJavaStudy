public final class Node<E> {
    private Node<E> next;
    private E value;

    Node() {
        next = null;
        value = null;
    }

    Node(E item) {
        next = null;
        value = item;
    }

    Node(E item, Node<E> next) {
        this.next = next;
        value = item;
    }

    Node<E> getNext() {
        return next;
    }

    E getValue() {
        return value;
    }

    void setNext(Node<E> next) {
        this.next = next;
    }

    void setValue(E value) {
        this.value = value;
    }
}
