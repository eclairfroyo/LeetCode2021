package com.ds.linear.basics.implmentation;

import java.util.ArrayList;

public class HashMapChainingImpl<K, V> {

    private static class HashMapDS<K,V> {
        public K key;
        public V value;
        public HashMapDS<K, V> next;
        //doubly linked list.
        public HashMapDS<K, V> prev;
        public HashMapDS(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<HashMapDS<K,V>> hashTable;
    public HashMapChainingImpl(int capacity) {
        hashTable =  new ArrayList<HashMapDS<K,V>>();

        // a hash table should be a prime for a even distribution of values.
        // Note : ensureCapacity() is req here, to have control over the size of hashtable.
        //        as arrayList's size doubles whenever the size is reached. our hash function depends on the table size.

        hashTable.ensureCapacity(capacity);
        System.out.println(capacity + " : " + hashTable.size());
        // why do we have set each value in hashTable arrayList to null ?
        // Ans : ensureCapacity sets only the base table size,
        for(int i = 0; i < capacity; i++){
            hashTable.add(null);
        }
        System.out.println(capacity + " : " + hashTable.size());
    }

    public void put(K key, V value) {

        if(key == null)
            return;
        //check if the key exists already.
        HashMapDS<K,V> node = getNode(key) ;
        if(node != null) {
            // if the key exists already replace the old value with cur value;
            node.value = value;
        }

        //if not, get the hash value and fetch corresponding list.
        node = new HashMapDS<>(key, value);
        int tableIndex = getHTableIndex(key);
        System.out.println("hash value is " + tableIndex);
        if(hashTable.get(tableIndex) != null) {
            //if there exists a list already for the given key,
            //  insert the new <key, value> in the front of the list.
            node.next = hashTable.get(tableIndex);
            node.next.prev = node;
        }
        hashTable.set(tableIndex, node);
        System.out.println("table size is : " + hashTable.size());
    }


    public V get(K key) {
        HashMapDS<K, V> node = getNode(key);
        return (node == null) ? null : node.value;
    }
    public HashMapDS getNode(K key) {
        int tableIndex = getHTableIndex(key);
        HashMapDS<K, V> node = hashTable.get(tableIndex);
        while(node != null) {
            if(node.key == key) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public int getHTableIndex(K key ) {
        return Math.abs(key.hashCode() % hashTable.size());
    }


    public void remove(K key) {
        //case 1 : key does not exists.
        //case 2 : key exists. middle of list. last of list.
        //case 3 : key exists. in the 1st index of list.

        HashMapDS node = getNode(key);
        if(node == null)
            System.out.println("Value not found.");
        else {
            if(node.next != null) {
                node.next.prev = node.prev;
            }
            if(node.prev != null) {
                node.prev.next = node.next;
            }
            else {
                int index = getHTableIndex(key);
                hashTable.set(index, node.next);
            }
        }
    }
}
