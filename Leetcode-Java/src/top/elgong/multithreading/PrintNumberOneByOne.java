package top.elgong.multithreading;

/**
 *  编程实现 两个线程交替打印数字0~100
 */
public class PrintNumberOneByOne {

    public static void main(String[] args) {

        MyThreadA m = new MyThreadA();

        new Thread(m, "线程A").start();
        new Thread(m, "线程B").start();


    }
}


class MyThreadA implements Runnable{

    private int num = 0;

    @Override
    synchronized public void run() {

        for(int i=0; i<50; i++){

            notify();

            System.out.println(Thread.currentThread().getName() + " : " + num);
            num += 1;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        System.out.println(Thread.currentThread().getName() + " : 结束");
    }
}
