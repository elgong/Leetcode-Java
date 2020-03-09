package top.elgong;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class test {
    public static void main(String[] args) throws Exception  {
//1.创建并启动线程

        System.out.println(Runtime.getRuntime().availableProcessors());
        Callable<Integer> call1 = new CallableImpl(0, 50000);
        Callable<Integer> call2 = new CallableImpl(50001, 100000);


        FutureTask<Integer> f1 = new FutureTask<>(call1);
        FutureTask<Integer> f2 = new FutureTask<>(call2);


    }
}
class CallableImpl implements Callable<Integer>{


    private int min;
    private int max;


    public CallableImpl(int min, int max) {
        this.min = min;
        this.max = max;
    }


    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum+=i;
        }

        while(true){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
