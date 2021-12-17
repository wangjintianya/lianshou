package com.cwr.lianshou;

import com.cwr.lianshou.scruct.bloom.MyBloomFilter;

public class learn {
    public static void main(String[] args) {
        String a = "hello world";
        System.out.println(a);
        MyBloomFilter myBloomFilter = new MyBloomFilter();
        myBloomFilter.add("aaa");
        System.out.println(myBloomFilter.isContain("bbb"));
        System.out.println(myBloomFilter.isContain("aaa"));
    }
}