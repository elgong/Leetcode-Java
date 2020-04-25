package top.elgong.cast;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        System.out.println(" 向上转型：  ");
        /* 向上转型 */
        Father f = new Son();

        System.out.println(f.Int);  // 打印 2
        System.out.println(f.Str);  // 打印 father  str


        f.say();  // 打印 son say :
        f.sayOnlyFather();  // 打印   father say 2

        /* 向下转型 */
        System.out.println(" 向下转型：  ");
        Son s = (Son)f;

        System.out.println(s.Int);  // 打印   222
        System.out.println(s.Str);  // 打印   son  str
        System.out.println(s.strOnlySon);   // 打印   strOnlySon

        s.say();  // 打印  son say :
        HashMap
    }
}
