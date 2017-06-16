package me.mkweb.techtalk.lambdas.a_problems;

import static java.lang.Thread.currentThread;

/**
 * @author Mario Kunz
 */
public class AnonymousClasses {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("Hello World, I am on thread %s", currentThread().getName());
            }
        }).start();

        new Thread(() -> System.out.printf("Hello World, I am on thread %s", currentThread().getName())).start();
    }
}
