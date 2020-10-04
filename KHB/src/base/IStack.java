public interface IStack<E> {
    void push(E item);

    E pop() throws IllegalStateException;

    int size();

    boolean isEmpty();
}
