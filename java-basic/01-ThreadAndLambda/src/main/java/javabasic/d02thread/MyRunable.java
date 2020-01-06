package javabasic.d02thread;

/**
 * Created by Leo on 2019/12/17.
 * Description :
 */
public class MyRunable implements Runnable {

    public void run() {

        for (int i = 0; i < 100; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
