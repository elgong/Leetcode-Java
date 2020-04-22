package top.elgong.cast;

/* Father.java */
public class Father {

    /* 静态类变量 */
    public static int staticInt = 1;
    public static String staticStr = "father static str";

    /* 实例变量 */
    public int Int = 2;
    public  String Str = "father str";

    /*  会被子类覆盖的方法  */
    public void say(){
        System.out.println("被子类覆盖的方法 :say ");
    }


    /*  不被子类覆盖的方法 */
    public void sayOnlyFather(){
        System.out.println("未被子类覆盖的方法 : sayOnlyFather");
    }


    /* 私有方法默认为  fianl， 不可被继承， 也不参与转型 */
    private void sleep(){
        System.out.println(" father sleep");
    }

}
