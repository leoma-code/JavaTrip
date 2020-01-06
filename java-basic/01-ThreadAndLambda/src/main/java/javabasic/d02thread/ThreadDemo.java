package javabasic.d02thread;

/**
 * Created by Leo on 2019/12/17.
 * Description :
 */

/*
*
* 实现Runable接口与集成Thread实现多线程的区别
* */
public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

//        MyThread mt = new MyThread();
//        mt.start();
//
//        MyThread myThread = new MyThread("zhangsan");
//        myThread.start();

//        new Thread(new MyRunable()).start();

        new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 20; i++) {
                    System.out.println("hello world : " + Thread.currentThread().getName());
                }
            }
        }.start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("hello world : " + Thread.currentThread().getName());
                }
            }
        }).start();


        for (int i = 0; i < 20; i++) {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }


    }
}
