package com.t2022.t01.t14;

public class TestLinkedTransferQueue {

    // 队列中的头部节点
    private transient final PaddedAtomicReference<QNode> head = null;
    // 队列中的尾部节点
    private transient final PaddedAtomicReference<QNode> tail = null;


    static final class PaddedAtomicReference<T> extends AtomicReference<T> {
        // 使用很多的4个字节的引用追加到6个字节
        Object p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, pa, pb, pc, pd, pe;



        public PaddedAtomicReference(T t) {
            super(t);
        }
    }


}
