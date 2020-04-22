import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {


        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put("123".getBytes(Charset.forName("utf-8")));

    }
}
