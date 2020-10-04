/*
 * Name: Kim Hyun Bae
 * Student ID #: 2017145086
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class Stack<E> implements IStack<E> {
    public Node<E> top = null;
    int size;

    public Stack() {
        size = 0;
    }

    @Override
    public void push(E item) {
        
        if(size == 0){
            top = new Node<E>();
            top.setValue(item);
            size++;
        } else {
            Node<E> tmp = new Node<E>(item,top);
            top = tmp;
            size++;
        }

    }

    @Override
    public E pop() throws IllegalStateException {
        
        E output;

        if(size == 0){
            throw new IllegalStateException();
        } else {
            output = top.getValue();
            top = top.getNext();
            size--;
        }

        return output;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
