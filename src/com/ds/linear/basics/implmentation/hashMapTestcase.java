package com.ds.linear.basics.implmentation;

public class hashMapTestcase {

    public static void main(String args[]) {
        HashMapChainingImpl hash_ = new HashMapChainingImpl(10);
        hash_.put(39, "Chennai");
        hash_.put(89, "Illusion");
        hash_.put(18, "Agatha");
        hash_.put(49, "Striver");
        hash_.put(58, "sudocode");
        hash_.put(69, "Indigo");
        System.out.println(hash_.get(39));
        hash_.put(39, "Striver");

        System.out.println(hash_.get(49));
        System.out.println(hash_.get(39));

    }
}
