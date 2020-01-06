package javabasic.d04threadwaitnotify;

/**
 * Created by Leo on 2019/12/18.
 * Description :
 */
public class BaoziPu extends Thread {

    private Baozi bz;

    public BaoziPu(Baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {

        int condition = 0;

        while (true) {

            synchronized (bz) {

                if (bz.flag) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (condition%2 == 0) {
                    bz.pi = "薄皮";
                    bz.xian = "荠菜猪肉馅";
                } else {
                    bz.pi = "冰皮";
                    bz.xian = "猪肉白菜馅";
                }

                bz.flag = true;
                System.out.println("包子铺正在生产" + bz.pi + bz.xian + "的包子");

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("包子铺生产好了" + bz.pi + bz.xian + "的包子");

                bz.notify();

                System.out.println("吃货可以来吃了。。。");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                condition++;
            }

        }

    }
}
