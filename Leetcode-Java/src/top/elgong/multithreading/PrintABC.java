package top.elgong.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
*   三线程 交替打印A  B  C 8 次
* 方法1：  利用 Condation 和 ReentrantLock 实现
*         每个线程 掌握 当前线程的Condation 和 下一个任务的 condation
* */
public class PrintABC {

    private static int count = 0;
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {

        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        PrintA printA = new PrintA(conditionA, conditionB);
        PrintB printB = new PrintB(conditionB, conditionC);
        PrintC printC = new PrintC(conditionC, conditionA);


        new Thread(printA).start();
        new Thread(printB).start();
        new Thread(printC).start();
    }


    // 打印A
    static class PrintA implements Runnable{
        Condition c;
        Condition next;
        public PrintA(Condition c, Condition next) {
            this.c = c;
            this.next = next;
        }

        @Override
        public void run() {
            lock.lock();
            try{
                for(int i=0; i<8; i++){
                    System.out.print(i+"A");

                    // 先唤醒下一个线程，会等待当前线程执行完
                    next.signal();
                    // 再让当前线程wait
                    c.await();
                }

                // 最后要唤醒线程一次。
                next.signal();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }


    // 打印B
    static  class PrintB implements Runnable{

        Condition c;
        Condition next;
        public PrintB(Condition c, Condition next) {
            this.c = c;
            this.next = next;
        }
        @Override
        public void run() {
            lock.lock();
            try{
                for(int i=0; i<8; i++){
                    System.out.print(i+"B");
                    // 先唤醒下一个线程，会等待当前线程执行完
                    next.signal();
                    // 再让当前线程wait
                    c.await();
                }

                // 最后要唤醒线程一次。
                next.signal();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }


    // 打印C
    static class PrintC implements Runnable{
        Condition c;
        Condition next;
        public PrintC(Condition c, Condition next) {
            this.c = c;
            this.next = next;
        }
        @Override
        public void run() {
            lock.lock();
            try{
                for(int i=0; i<8; i++){
                    System.out.print(i+"C ");
                    // 先唤醒下一个线程，会等待当前线程执行完
                    next.signal();
                    // 再让当前线程wait
                    c.await();
                }

                // 最后要唤醒线程一次。
                next.signal();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }


}
