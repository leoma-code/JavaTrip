package javabasic.d05threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Leo on 2019/12/18.
 * Description :
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.submit(new RunnableImpl());
            executorService.submit(new RunnableImpl());
            executorService.submit(new RunnableImpl());
        }

        // 关闭线程池
        executorService.shutdown();

    }
}
