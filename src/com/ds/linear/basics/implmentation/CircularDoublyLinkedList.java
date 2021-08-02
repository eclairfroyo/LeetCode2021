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
        List cur = root;

        do{
            size++;
            cur = cur.next;
        }while(root != cur);

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
        if(root == null)
            return;
        List head = root;
        do{
            System.out.print(root.value + "  ");
            root = root.next;
        }while(root != head);

        System.out.println();
    }

    public static void printListByPrev(List root) {
        if(root == null)
            return;
        List head = root;
        do{
            System.out.print(root.value + "  ");
            root = root.prev;
        }while(root != head);

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
        if(index == 0)
            root = newNode;
        while(--index >= 0)
            cur = cur.next;

        newNode.next = cur;
        newNode.prev = cur.prev;
        cur.prev.next = newNode;
        cur.prev = newNode;
        return root;
    }

    //delete at first.
    public static List deleteAtFirst(List root) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 1
        if(root == null || root.next == root)
                return null;
        root.next.prev = root.prev;
        root.prev.next = root.next;
        return root.next;
    }

    //delete at last.
    public static List deleteAtLast(List root) {
        if(root == null || root.next == root)
            return null;
        root.prev.prev.next = root;
        root.prev = root.prev.prev;
        return root;
    }

    //delete elem at pos.
    public static List deleteAtPos(List root, int index) {
        int size = getListSize(root);

        if(index == 0 && size == 1)
            return null;
        if(index > size) {
            System.out.println("Index out of range.");
            return root;
        }

        List cur = root;
        if(index == 0 )
            root = root.next;
        while(--index >= 0)
            cur = cur.next;
        cur.next.prev = cur.prev;
        cur.prev.next = cur.next;
        return root;
    }
    public static void main(String args[]) {
        List root = new List(10);
        root.prev = root;
        root.next = root;
        root = insertAtIndex(95, 0, root);
        printList(root);
        root = insertAtLast(-2, root);
        printList(root);
        root = insertAtIndex(15, 0, root);
        printList(root);
        root = insertAtLast(1, root);
        root = insertAtFirst(2, root);
        //printList(root);
        root = insertAtLast(3, root);
        //printList(root);
        root = insertAtIndex(5, 2, root);
        root = insertAtIndex(1005, 0, root);
        printList(root);

        System.out.println("Delete results : ");
        root = deleteAtPos(root,6);
        printList(root);
        root = deleteAtPos(root,3);
        printList(root);
        root = deleteAtPos(root,0);
        printList(root);
        root = deleteAtFirst(root); //2
        printList(root);
        root = deleteAtFirst(root); //10
        printList(root);
        root = deleteAtLast(root);
        printList(root);
        root = deleteAtFirst(root);
        printList(root);
        root = deleteAtFirst(root);
        printList(root);
        root = deleteAtFirst(root);
        printList(root);
        root = deleteAtFirst(root);
        printList(root);

    }

}
