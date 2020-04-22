package top.elgong.someFeature;

/*
*   内部类测试
* */
public class InnerClass {
    private static int staticNum = 1;
    public int Num = 2;

    // 创建一个静态类的对象
    public StaticClass s = new StaticClass();

    // 创建一个费静态类的对象
    public UnStaticClass us = new UnStaticClass();

    public static void main(String[] args) {

    }

    static class StaticClass{
        // 代码测试时使用
        public static void main(String[] args) {

            System.out.println("内部静态类测试");
            System.out.println("外部类的静态变量 " + staticNum );
        }
    }


    class UnStaticClass{

        private String unStaticClass = "非静态的内部类";

        // 修改外部的元素

        public void printOut(){
            System.out.println("访问外部类的 成员" + Num);
            Num += 1;
            System.out.println("修改外部类的 成员" + Num);
        }
    }
}
