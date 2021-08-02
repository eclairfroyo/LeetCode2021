package com.ds.linear.basics.implmentation;

public class Queue <E>{

    private int front, rear, size;
    private Object elements[];

    Queue(int size) {
        this.size = size;
        elements = new Object[size];
        front = rear = 0;
    }

    public void enqueue(E e) {
        if (size == rear)
            System.out.println("Queue is full");  // or we could call ensureCapacity();
        else
            elements[rear++] = e;
        return;
    }

    public E dequeue() {
        if(front == rear)
            System.out.println("Queue is empty");
        else
            return (E) elements[--front];
        return null;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = front; i < rear; i++) {
            sb.append(elements[i].toString());
            if(i < rear - 1){
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}

class Main {
    public static void main(String args[]) {
        Queue<Long> queue = new Queue<Long>(10);

        queue.enqueue(10l);
        queue.enqueue(20l);
        queue.enqueue(30l);
        queue.enqueue(40l);

        System.out.println(queue);

        System.out.println( queue.dequeue() );
        System.out.println( queue.dequeue() );
        System.out.println( queue.dequeue() );

        System.out.println( queue );
    }
}

