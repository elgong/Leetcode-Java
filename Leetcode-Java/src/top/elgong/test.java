package top.elgong;


import java.util.concurrent.*;

public class test {
    public static void main(String[] args) throws Exception  {
//1.创建并启动线程

        Executors
        Callable<Integer> call1 = new CallableImpl(0, 50000);
        Callable<Integer> call2 = new CallableImpl(50001, 100000);


        FutureTask<Integer> f1 = new FutureTask<>(call1);
        FutureTask<Integer> f2 = new FutureTask<>(call2);


        new Thread(f1).start();
        new Thread(f2).start();
//2.获取每一个线程的结果
        int ret1 = f1.get();
        int ret2 = f2.get();
        int ret= ret1+ret2;
        System.out.println(ret);
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
        return sum;
    }
}
