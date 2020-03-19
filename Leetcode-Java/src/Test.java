import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        Lock obj = new ReentrantLock();

        obj.lock();
        try {
            System.out.println(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            obj.unlock();
        }



    }
}
