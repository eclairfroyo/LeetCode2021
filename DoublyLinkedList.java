package com.ds.linear.basics.implmentation;

public class DoublyLinkedList {

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

    //insert at begining.
    public static List insertAtFirst(int val, List root) {
        List node = new List(val, root, null);
        root.prev = node;
        root = node;
        return root;
    }

    //insert at last.
    public static List insertAtLast(int val, List root) {
        List cur = root;
        List newNode = new List(val, null, null);
        if(cur == null)
            return newNode;
        while(cur.next != null)
            cur = cur.next;
        newNode.prev = cur;
        cur.next = newNode;
        return root;
    }

    //insert at a pos.
    public static List insertAtIndex(int val, int index, List root) {
        if(index > getListSize(root)) {
            System.out.println("Index out of range.");
            return root;
        }
        List cur = root;
        List newNode = new List(val, null, null);

        if(index == 0) {
            newNode.next = root;
            root.prev = newNode;
            return newNode;
        }

        while(--index > 0)
            cur = cur.next;

        newNode.next = cur.next;
        newNode.prev = cur;
        cur.next = newNode;
        if(cur.next != null)
            cur.next.prev = newNode;
        return root;
    }

    //delete at first.
    public static List deleteAtFirst(List root) {
        if(root != null) {
            if(root.next != null)
                root.next.prev = null;
            return root.next;
        }
        return null;
    }

    //delete at last.
    public static List deleteAtLast(List root) {
        if(root == null || root.next == null)
            return null;
        List cur = root;
        while(cur.next != null)
            cur = cur.next;
        cur.prev.next = null;
        return root;
    }

    //delete elem at pos.
    public static List deleteAtPos(List root, int index) {
        if(index > getListSize(root)) {
            System.out.println("Index out of range.");
            return root;
        }
        List cur = root;
        if(index == 0){
            cur.next.prev = null;
            return cur.next;
        }
        while(--index > 0)
            cur = cur.next;
        if(cur.next != null) {
            cur.next.prev = cur;
            cur.next =  cur.next.next;
        }
        return root;
    }

    //delete by value.
//    public static LinkedList.List deleteByValue(LinkedList.List root, int value) {
//        LinkedList.List cur = root, prev = null;
//        while(cur != null) {
//            if (cur.value == value) {
//                if (prev == null)
//                    return cur.next;
//                prev.next = cur.next;
//                break;
//            }
//            prev = cur;
//            cur = cur.next;
//        }
//        return root;
//    }

    public static void main(String args[]) {
        List root = new List(10);
        root = insertAtLast(-2, root);
        root = insertAtIndex(15, 0, root);
        root = insertAtLast(1, root);
        root = insertAtFirst(2, root);
        root = insertAtLast(3, root);
        root = insertAtIndex(5, 2, root);
        printList(root);

        System.out.println("Delete results : ");
        root = deleteAtPos(root,6);
        printList(root);
        root = deleteAtPos(root,3);
        printList(root);
        root = deleteAtPos(root,0);
        printList(root);
        root = deleteAtFirst(root);
        printList(root);
        root = deleteAtLast(root);
        //root = deleteByValue(root,10);
        printList(root);
    }
}
