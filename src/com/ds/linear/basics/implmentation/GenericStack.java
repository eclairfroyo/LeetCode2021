package com.ds.linear.basics.implmentation;

import java.util.Arrays;

public class GenericStack<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public GenericStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    public E pop() {
        if(size == 0)
            return null;
        E e = (E) elements[--size];
        elements[size] = null;
        return e;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size ;i++) {
            sb.append(elements[i].toString());
            if(i < size-1){
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
class Main {
   public static void main(String args[]) {
       GenericStack<Long> stack = new GenericStack<>();

       stack.push(10l);
       stack.push(20l);
       stack.push(30l);
       stack.push(40l);

       System.out.println(stack);

       System.out.println( stack.pop() );
       System.out.println( stack.pop() );
       System.out.println( stack.pop() );

       System.out.println( stack );
   }
}
