package javabasic.d03threadsafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Leo on 2019/12/17.
 * Description :
 */
public class RunnableImpl implements Runnable {

    private int ticket = 100;

    Object obj = new Object();

    Lock l = new ReentrantLock();


    public void run() {

        while (true) {

//            synchronized (obj) { // 同步代码块
//                if (ticket > 0) {
//
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println("Thread : " + Thread.currentThread().getName() + " 正在卖第" + ticket + "张票");
//                    ticket--;
//                }
//            }

//            sellTicket();

            l.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(50);
                    System.out.println("Thread : " + Thread.currentThread().getName() + " 正在卖第" + ticket + "张票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    l.unlock();
                }
            }

        }

    }

    private synchronized void sellTicket() {
        if (ticket > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread : " + Thread.currentThread().getName() + " 正在卖第" + ticket + "张票");
            ticket--;
        }
    }
}
