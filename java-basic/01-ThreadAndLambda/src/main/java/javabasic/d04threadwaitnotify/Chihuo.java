package javabasic.d04threadwaitnotify;

/**
 * Created by Leo on 2019/12/18.
 * Description :
 */
public class Chihuo extends Thread {

    private Baozi bz;

    public Chihuo(Baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (bz) {

                if (!bz.flag) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("吃货正在吃" + bz.pi + bz.xian + "的包子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = false;
                bz.notify();

                System.out.println("吃货把" + bz.pi+ bz.xian + "的包子吃完了，包子铺可以继续生产了");

                System.out.println("-----------------------------------------------------------------------------");



            }
        }
    }
}
