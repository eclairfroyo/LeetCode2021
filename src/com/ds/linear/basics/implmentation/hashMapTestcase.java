package com.ds.linear.basics.implmentation;

public class hashMapTestcase {

    public static void main(String args[]) {
        HashMapChainingImpl hash_ = new HashMapChainingImpl(7);
        hash_.put(39, "Chennai");
        hash_.put(89, "Illusion");
        hash_.put(18, "Agatha");
        //3
        hash_.put(49, "Striver");
        hash_.put(58, "sudocode");
        hash_.put(69, "Indigo");
        //6
        hash_.put(39, "Striver");
        hash_.put(199, "one");
        hash_.put(209, "two");
        //9
        hash_.put(9, "three");
        hash_.put(99, "four");
        hash_.put(19, "five");
        //12
        hash_.put(6, "abc");
        hash_.put(12, "efgh");
        hash_.put(24, "lmnbh");
        //15
    }
}
