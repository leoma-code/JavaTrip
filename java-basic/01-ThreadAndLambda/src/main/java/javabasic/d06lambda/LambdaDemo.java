package javabasic.d06lambda;

/**
 * Created by Leo on 2019/12/18.
 * Description :
 */
public class LambdaDemo {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "创建了一个新线程");
            }
        }).start();

        // Lambda标准格式  (参数列表) -> { 方法体 }
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName() + "创建了一个新线程");
        }).start();







    }
}
