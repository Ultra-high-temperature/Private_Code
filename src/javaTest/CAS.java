package javaTest;

import CI.JZ3;

import java.util.concurrent.atomic.AtomicStampedReference;

public class CAS {
    void t1(){
        AtomicStampedReference<JZ3.ListNode> atomicStampedReference = new AtomicStampedReference<>(new JZ3.ListNode(0),1);
//        atomicStampedReference.compareAndSet()

    }
}
