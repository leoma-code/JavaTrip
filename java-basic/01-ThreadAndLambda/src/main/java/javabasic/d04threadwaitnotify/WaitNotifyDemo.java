package javabasic.d04threadwaitnotify;

/**
 * Created by Leo on 2019/12/18.
 * Description :
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {

        Baozi bz = new Baozi();

        new BaoziPu(bz).start();
        new Chihuo(bz).start();


    }



}
