package com.cwr.lianshou.scruct.bloom;

import java.util.BitSet;

public class MyBloomFilter {
    /**
     * 位数组大小
     */
    private static final int DEFAULT_BIT = 2 << 24;
    /**
     * 通过这个数组可以创建 6 个 hash 函数
     */
    private static final int[] SEEDS = {3, 13, 46, 71, 91, 134};

    private final BitSet bitSet = new BitSet(DEFAULT_BIT);

    /**
     * 存放包含hash函数类的数组
     */

    private final SimpleHash[] simpleHash = new SimpleHash[SEEDS.length];

    public MyBloomFilter() {
        for(int i = 0; i < SEEDS.length; i++) {
            simpleHash[i] = new SimpleHash(DEFAULT_BIT, SEEDS[i]);
        }
    }

    /**
     * 添加元素到位数组
     * @param value 值
     */
    public void add(Object value) {
        for (SimpleHash s: simpleHash) {
            bitSet.set(s.hash(value), true);
        }
    }

    /**
     * 判断指定元素是否存在于位数组
     * @param value 值
     * @return 是否包含
     */
    public boolean isContain(Object value) {
        boolean isContain = true;
        for(SimpleHash s: simpleHash) {
            if (!bitSet.get(s.hash(value))) {
                isContain = false;
                break;
            }
        }

        return isContain;
    }



    /**
     * 静态内部类。用于 hash 操作！
     */
    public static class SimpleHash {

        private final int cap;
        private final int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        /**
         * 计算 hash 值
         */
        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }

    }

}

