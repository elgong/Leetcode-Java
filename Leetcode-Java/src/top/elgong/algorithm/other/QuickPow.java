package top.elgong.algorithm.other;

/*
*  快速幂运算
*
*  时间复杂度： O(log2N)
*
*  原理：文档：快速幂运算.md
链接：http://note.youdao.com/noteshare?id=4d602eda6d51d1f1a656694951e218ba&sub=F32C820CFFE44712A988E55C186BD8E3
*
*
* */
public class QuickPow {

    public static double quickPow(double num, int p)  {

        // 底数=0
        if (num == 0){
            return 0.0;
        }

        // 指数为 0
        if (p == 0){
            return 1.0;
        }

        // 处理负数时， 直接翻转会溢出  -Integer.MIN_VALUE 溢出
        long pLong = p;
        if (pLong < 0){
            pLong = -pLong;
            num = 1.0/num;
        }

        double res = 1.0;
        while (pLong > 0){
            // 末位
            if ((pLong & 1) == 1){
                res *= num;
            }

            num *= num;
            pLong >>= 1;
        }
        return res;
    }


    /**
     *  内部测试类
     */
    static class Test{
        public static void main(String[] args) {
            System.out.println(QuickPow.quickPow(1.2, 2));
            System.out.println(QuickPow.quickPow(4, 3));
        }
    }
}
