package javaTest;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static final  ReentrantReadWriteLock.ReadLock readLock  = reentrantReadWriteLock.readLock();
    private static final  ReentrantReadWriteLock.WriteLock writeLock  = reentrantReadWriteLock.writeLock();

    public static void main(String[] args) {
//        writeLock.lock();
        boolean heldByCurrentThread = writeLock.isHeldByCurrentThread();
        writeLock.unlock();
    }
}
