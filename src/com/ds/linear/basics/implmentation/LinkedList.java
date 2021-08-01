package com.ds.linear.basics.implmentation;
//SLL
public class LinkedList {

    public static class List {
        int value;
        List next;
        //protected LinkedList root = null;
        List(int val) {
            this.value = val;
            this.next = null;
        }
        List(int val, List next) {
            this.value = val;
            this.next = next;
        }
    }

    //list size.
    public static int getListSize(List root) {
        int size = 0;
        while(root != null) {
            size ++;
            root = root.next;
        }
        System.out.println("size of list is " + size);
        return size;
    }

    //insert at begining.
    public static List insertAtFirst(int val, List root) {
        List node = new List(val, root);
        root = node;
        return root;
    }

    //insert at last.
    public static List insertAtLast(int val, List root) {
        List cur = root;
        if(cur == null)
            return new List(val);
        while(cur.next != null)
            cur = cur.next;
        cur.next = new List(val);
        return root;
    }

    //insert at a pos.
    public static List insertAtIndex(int val, int index, List root) {
        if(index > getListSize(root)) {
            System.out.println("Index out of range.");
            return root;
        }
        List cur = root;
        if(index == 0)
            return new List(val, root);

        while(--index > 0)
            cur = cur.next;
        List next = cur.next;
        cur.next = new List(val, next);
        return root;
    }

    //search an elem.
    public static List searchByValue(int value, List root) {
        List cur = root;
        while(cur != null) {
            if(cur.value == value)
                return cur;
            cur = cur.next;
        }
        System.out.println("Value not found");
        return null;
    }

    //print all elems in a linked list.
    public static void printList(List root) {
        //LinkedList cur = root;
        while(root != null){
            System.out.print(root.value + "  ");
            root = root.next;
        }
        System.out.println();
    }

    //delete at first.
    public static List deleteAtFirst(List root) {
        if(root != null)
            return root.next;
        return null;
    }

    //delete at last.
    public static List deleteAtLast(List root) {
        if(root == null || root.next == null)
            return null;
        List cur = root;
        while(cur.next != null && cur.next.next != null)
            cur = cur.next;
        cur.next = null;
        return root;
    }

    //delete elem at pos.
    public static List deleteAtPos(List root, int index) {
        if(index > getListSize(root)) {
            System.out.println("Index out of range.");
            return root;
        }
        List cur = root;
        if(index == 0)
            return cur.next;
        // 2 -> 6 -> 4 -> null
        // index 2. 3rd element.
        while(--index > 0)
            cur = cur.next;
        cur.next = cur.next != null ? cur.next.next : null;
        return root;
    }

    //delete by value.
    public static List deleteByValue(List root, int value) {
        List cur = root, prev = null;
        while(cur != null) {
            if (cur.value == value) {
                if (prev == null)
                    return cur.next;
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return root;
    }

    public static void main(String args[]) {
        List root = new List(10);
        root = insertAtLast(-2, root);
        root = insertAtLast(1, root);
        root = insertAtFirst(2, root);
        root = insertAtLast(3, root);
        printList(root);
        root = insertAtIndex(5, 2, root);
        root = insertAtIndex(15, 0, root);
        printList(root);

        List cur = searchByValue(10, root);
        System.out.println("search by value");
        printList(cur);
        getListSize(root);

        root = deleteAtFirst(root);
        root = deleteAtLast(root);
        root = deleteByValue(root,10);
        root = deleteAtPos(root,2);
        printList(cur);
    }
}
