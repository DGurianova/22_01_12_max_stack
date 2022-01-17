package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.Stack;

public class NaiveMaxStack implements MaxStack {

    private final Deque<Integer> source = new ArrayDeque<>();
    Stack<Integer> sourceStackMax = new Stack<Integer>();

    @Override
    public void add(int elt) {
        source.addLast(elt);
        if (sourceStackMax.size() == 0) {
            throw new EmptyStackException();
        }
        if (sourceStackMax.peek() < elt) {
            sourceStackMax.push(elt);
        }
    }

    @Override
    public int get() {
        return source.getLast();
    }

    @Override
    public int remove() {
        int elt = source.removeLast();
        if (sourceStackMax.size() == 0) {
            throw new EmptyStackException();
        }
        if (elt == sourceStackMax.peek()) {
            sourceStackMax.pop();
        }
        return elt;
    }

    @Override
    public int size() {
        return source.size();
    }

    @Override
    public int getMax() {
        if (sourceStackMax.size() > 0) {
            return sourceStackMax.peek();
        }
        throw new EmptyStackException();
    }
}
