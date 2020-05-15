import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {


        lengthOfLongestSubstring("bbtablud");

    }


    public static  int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1){
            return s.length();
        }

        HashMap<Character, Integer> slipWindows = new HashMap();

        int max = 1;
        for (int i = 0; i < s.length(); i++){

            //bbtablud
            if ( !slipWindows.containsKey(s.charAt(i)) ){
                slipWindows.put(s.charAt(i), i);
                if (slipWindows.size() > max){
                    max = slipWindows.size();
                }

            } else{
                // 出现重复值， 那么久删除
                int index = slipWindows.get(s.charAt(i));
                slipWindows.put(s.charAt(i), i);
                for (int j = index - 1; j >= 0; j--){

                    if (!slipWindows.containsKey(s.charAt(j)) ){
                        break;
                    }else{
                        slipWindows.remove(s.charAt(j));
                    }
                }
            }
        }

        return max;

    }
}
