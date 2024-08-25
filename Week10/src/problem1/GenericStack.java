package problem1;

import java.util.Arrays;

public class GenericStack<E> {
    public final static int INITIAL_SIZE = 16;
    private E[] elements;
    private int size;
    //private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    public GenericStack() {
        this(INITIAL_SIZE);
    }

    public GenericStack(int initialCapacity) {
       elements = (E[])new Object[initialCapacity];
    }

    public E push(E value) {
        if(size >= elements.length) {
            E[] temp = (E[]) new Object[elements.length + 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        return elements[size++] = value;
    }


    public int getSize() {
        return size;
    }

    public E peek() {
        return elements[size - 1];
    }

    public E pop() {
        return elements[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "stack: " + Arrays.toString(elements);
    }
}