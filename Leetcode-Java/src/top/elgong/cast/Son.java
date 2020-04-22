package top.elgong.cast;

/* Son.java */
public class Son extends Father {

    /* 子类的 变量区 */
    /* 静态变量 */
    public static int staticInt = 111;
    public static String staticStr = "son static str";

    /* 实例变量 */
    public int Int = 222;
    public  String Str = "son  str";

    /* 子类独有的变量 */
    public String strOnlySon = "str Only Son";


    @Override
    public void say() {
        System.out.println("子类重写的方法：say");
    }

    public void sleep(){
        System.out.println("子类独有的方法： son sleep : ");
    }

}
