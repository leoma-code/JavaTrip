package javabasic.d03threadsafe;

/**
 * Created by Leo on 2019/12/17.
 * Description :
 */
public class ThreadSafeDemo {

    public static void main(String[] args) {

        RunnableImpl runnable = new RunnableImpl();

        Thread t0 = new Thread(runnable);
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t0.start();
        t1.start();
        t2.start();
    }
}
