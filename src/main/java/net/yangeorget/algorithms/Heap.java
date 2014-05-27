package net.yangeorget.algorithms;

/**
 * A heap.
 * @author Yan Georget
 */
public interface Heap<T extends Comparable<T>> {
    void clear();

    void add(T o);

    boolean isEmpty();

    T pop();
}
