package javabasic.d02thread;

/**
 * Created by Leo on 2019/12/17.
 * Description :
 */
public class MyThread extends Thread {

    public MyThread() {}
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 200; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + "-" + i);
        }
    }
}
