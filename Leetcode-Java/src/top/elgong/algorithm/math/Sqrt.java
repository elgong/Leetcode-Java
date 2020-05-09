package top.elgong.algorithm.math;

// 实现开根号
public class Sqrt {

    public static void main(String[] args) {

        long s = System.currentTimeMillis();
        System.out.println(sqrtByBinary(500, 0.0001));

        System.out.println(System.currentTimeMillis() - s);
        s = System.currentTimeMillis();


        System.out.println(sqrtByNIUDUN(500, 0.0001));
        System.out.println(System.currentTimeMillis() - s);
    }

    /**
     *  二分法求 sqrt
     *
     * @param num  ： 被开方数
     * @param precision ： 精度
     * @return ： 结果
     */
    public static double sqrtByBinary(int num, double precision){

        double min = 0.0;  // 下线
        double max = num;  // 上限

        double mid = (max-min)/2.0;

        while(Math.abs(mid*mid-num) > precision){
            // 结果大， 说明 mid 偏大
            if(mid*mid > num){
                max = mid;  // 调整上限
            }else if( mid*mid < num){
                min = mid;
            }else{
                return mid;
            }

            mid = min + (max-min)/2.0;

        }

        return mid;
    }


    /**
     *  牛顿迭代法 求解 sqrt
     *
     *  公式： target -= (target * target - x) / (2 * target)
     * @param num
     * @param precision
     * @return
     */
    public static double sqrtByNIUDUN(int num, double precision){

        double target = num;  // 目标初始化为num

        double err = num; // 迭代前后的误差
        while (err > precision){

            err = target;
            target -= (target * target - num) / (2 * target);
            err = Math.abs(target - err);
        }

        return target;

    }
}
