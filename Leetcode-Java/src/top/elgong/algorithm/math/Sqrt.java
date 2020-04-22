package top.elgong.algorithm.math;

// 实现开根号
public class Sqrt {

    public static void main(String[] args) {

        System.out.println(sqrt(5, 0.0001));
    }

    // 二分法
    public static double sqrt(int num, double precision){

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
}
