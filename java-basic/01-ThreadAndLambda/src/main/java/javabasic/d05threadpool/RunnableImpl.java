package javabasic.d05threadpool;

/**
 * Created by Leo on 2019/12/18.
 * Description :
 */
public class RunnableImpl implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + "创建了一条线程");
    }
}
