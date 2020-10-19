package com.pql.thread;

public class NoSafe {

    public int i = 0;

    public class NoSafeThread extends Thread{

        @Override
        public void run() {
            for (int j = 0; j < 2000; j++) {
                i++;
                System.out.println(Thread.currentThread().getName()+ "---"+i);
            }
        }
    }



    public void test() {
        for (int a = 0; a < 10; a++){

            NoSafeThread noSafeThread1 = new NoSafeThread();
            noSafeThread1.start();
        }
        while (i < 20000){
        }
    }

    public static void main(String[] args) {
        NoSafe noSafe = new NoSafe();
        noSafe.test();
    }

}
