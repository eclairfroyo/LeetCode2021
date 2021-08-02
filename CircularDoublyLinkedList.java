package com.ds.linear.basics.implmentation;

public class CircularDoublyLinkedList {

    public static class List {
        int value;
        List next;
        List prev;

        //protected LinkedList root = null;
        List(int val) {
            this.value = val;
            this.next = null;
            this.prev = null;
        }
        List(int val, List next, List prev) {
            this.value = val;
            this.next = next;
            this.prev = prev;
        }
    }

    //list size.
    public static int getListSize(List root) {
        int size = 0;
        while(root != null) {
            size++;
            root = root.next;
        }
        //System.out.println("size of list is " + size);
        return size;
    }

    //search an elem.
    public static List searchByValue(int value, List root) {
        List cur = root;
        do {
            if(cur == null)
                break;
            if(cur.value == value)
                return cur;
            cur = cur.next;
        }while(cur.next != root);
        System.out.println("Value not found");
        return null;
    }

    //print all elems in a linked list.
    public static void printList(List root) {
        if(root != null)
            System.out.print(root.value + "  ");
        List head = root;
        while(root.next != head){
            root = root.next;
            System.out.print(root.value + "  ");
        }
        System.out.println();
    }

    public static void printListByPrev(List root) {
        if(root != null)
            System.out.print(root.value + "  ");

        List head = root;
        while(root.next != head){
            System.out.print(root.value + "  ");
            root = root.prev;
        }
        System.out.println();
    }

    //insert at begining.
    public static List insertAtFirst(int val, List root) {
        List node = new List(val, null, null);
        if(root != null) {
            root.prev.next = node;
            node.prev = root.prev;
            node.next = root;
            root.prev = node;
        }
        else {
            node.next = node;
            node.prev = node;
        }
        root = node;
        return root;
    }

    //insert at last.
    public static List insertAtLast(int val, List root) {
        List node = new List(val, null, null);
        // 1 -> 2 -> 3 -> 4 -> 5 -> 1
        if(root != null) {
            root.prev.next = node;
            node.next = root;
            node.prev = root.prev;
            root.prev = node;
        }
        else {
            node.next = node;
            node.prev = node;
        }
        return root;
    }

    //insert at a pos.
    public static List insertAtIndex(int val, int index, List root) {
        if(index > getListSize(root)) {
            System.out.println("Index out of range.");
            return root;
        }
        List newNode = new List(val, null, null);
        if(root == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            return newNode;
        }

        List cur = root;
        while(--index >= 0)
            cur = cur.next;
        //    1 -> 2 -> 3 -> 4 -> 5 -> 1
        //    1 -> 1
        //    2 -> 1
        System.out.println("test");
        newNode.next = cur;
        newNode.prev = cur.prev;
        cur.prev.next = newNode;
        cur.prev = newNode;
        return root;
    }

    public static void main(String args[]) {
        List root = new List(10);
        root.prev = root;
        root.next = root;
        printList(root);
        root = insertAtLast(-2, root);
        printList(root);
        //root = insertAtIndex(15, 0, root);
        root = insertAtLast(1, root);
        printList(root);
        root = insertAtFirst(2, root);
        printList(root);
        root = insertAtLast(3, root);
        printList(root);
        root = insertAtIndex(5, 2, root);
        printList(root);

//        System.out.println("Delete results : ");
//        root = deleteAtPos(root,6);
//        printList(root);
//        root = deleteAtPos(root,3);
//        printList(root);
//        root = deleteAtPos(root,0);
//        printList(root);
//        root = deleteAtFirst(root);
//        printList(root);
//        root = deleteAtLast(root);
//        //root = deleteByValue(root,10);
//        printList(root);
    }

}
