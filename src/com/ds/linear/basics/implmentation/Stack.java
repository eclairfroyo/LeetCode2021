package com.ds.linear.basics.implmentation;

public class Stack {
    private static int size;
    private static int arr[];
    private static int top;

    Stack(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public static boolean isFull() {
        return (top == size - 1);
    }
    public static boolean isEmpty() {
        return (top == -1);
    }
    public static int peek() {
        if(!isEmpty())
            return arr[top];

        System.out.println("Stack is empty");
        return -1;
    }
    public static int pop() {
        if(!isEmpty())
            return arr[top--];

        System.out.println("Stack is empty");
        return -1;
    }
    public static void push(int insertVal) {
        if(!isFull())
            arr[++top] = insertVal;
        else
            System.out.println("Stack is full");
    }
    public static void main(String[] args) {
        Stack StackCustom = new Stack(10);
        System.out.println(Stack.pop());
        Stack.push(35);
        Stack.push(3);
        Stack.push(9);
        Stack.push(100);
        System.out.println(Stack.pop());
        System.out.println(Stack.pop());
        System.out.println(Stack.pop());
        System.out.println(Stack.peek());
    }

}
