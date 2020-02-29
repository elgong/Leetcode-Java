package top.elgong.multithreading;

public class Test {

    public static void main(String[] args) {



        MyThread t =  new MyThread();
        t.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for(int i=0; i<100; i++){
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }
}


class MyThread extends Thread{

    @Override
    public void run() {
        for(int i=0; i<100; i++){
            System.out.println(Thread.currentThread().getName() + "  " + i);
        }
    }
}


