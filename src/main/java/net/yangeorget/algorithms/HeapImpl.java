package net.yangeorget.algorithms;

/**
 * A heap implementation.
 * @author Yan Georget
 * @param <U>
 */
public class HeapImpl <T extends Comparable<T>> implements Heap<T> {
    /** The array storing the heap elements, used starting from index 1. */
    private T[] elements;
    /** The size of the heap. */
    private int size;

    /**
     * Sole constructor.
     * @param elements an array used for storing the heap elements
     */
    public HeapImpl(T[] elements) {
        this.elements = elements;
    }

    /**
     * Clears the heap.
     */
    public final void clear() {
        size = 0;
    }

    /**
     * Adds an object to the heap.
     * @param o an object
     */
    public void add(T o) {
        elements[++size] = o; // TODO: check capacity
        up(size);
    }

    /**
     * Checks if the heap is empty.
     * @return a boolean
     */
    public final boolean isEmpty() {
        return size == 0;
    }

    /**
     * Pops an element (the top).
     * @return an object
     */
    public final T pop() {
        if (size > 0) {
            final T tmp = elements[1];
            elements[1] = elements[size--];
            down(1);
            return tmp;
        } else {
            return null;
        }
    }

    /**
     * Checks if the index corresponds to a leaf
     * @param i an index
     * @return a boolean
     */
    private final boolean isNotLeaf(int i) {
        return (i << 1) <= size;
    }

    /**
     * Returns the smallest son.
     * @param pos an index
     * @return an index
     */
    private final int smallestSon(int pos) {
        final int left = pos << 1;
        final int right = left + 1;
        if (right <= size && smaller(right, left)) {
            return right;
        } else {
            return left;
        }
    }

    /**
     * Swaps two elements.
     * @param i an index
     * @param j an index
     */
    private void swap(int i, int j) {
        final T tmp = elements[i];
        elements[i] = elements[j];
        elements[j] = tmp;
    }

    /**
     * Compares two elements.
     * @param i an index
     * @param j an index
     * @return a boolean
     */
    private final boolean smaller(int i, int j) {
        return elements[i].compareTo(elements[j]) < 0;
    }

    /**
     * Pushes an element up.
     * @param pos an index
     */
    private final void up(int pos) {
        if (pos > 1) {
            final int father = pos >> 1;
            if (smaller(pos, father)) {
                swap(pos, father);
                up(father);
            }
        }
    }

    /**
     * Pushes an element down.
     * @param pos an index
     */
    private final void down(int pos) {
        if (isNotLeaf(pos)) {
            final int son = smallestSon(pos);
            if (smaller(son, pos)) {
                swap(pos, son);
                down(son);
            }
        }
    }
}
