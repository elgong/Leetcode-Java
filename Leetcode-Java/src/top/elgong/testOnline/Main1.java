package top.elgong.testOnline;

import java.util.Arrays;
import java.util.Scanner;

/*
*  度小满金融：
*
* T1 :
* 在机器学习中有一种流行的池化操作，而在池化操作中，3*3极大值池化应用十分广泛。什么是3*3极大值池化呢？
* 设原矩阵是n*m的，则3*3极大值池化就是枚举矩阵中的所有3*3的子矩阵,分别求最大值并顺次拼接而成，处理过后的矩阵是(n-2)*(m-2)。

    例如，原矩阵是[[1,2,3,4],[5,6,7,8],[9,10,11,12]],经过池化之后就变成[[11,12]]。

    为了提高难度，选择的滑动窗口并不是3*3的，而是a*b的，由于输入可能是非常大的，
*   原n*m的矩阵权值由以下公式计算得到，h(i,j)=i*j mod 10。(1<=i<=n,1<=j<=m)

    由于输出矩阵也是一个很麻烦的事情，因此你只需输出经过a*b池化处理后的矩阵的元素之和即可。
*
*   n,m,a,b
*   h(i,j)=i*j mod 10。
*
*
*
*
* 西西所在的国家有N座城市，每座城市都有一道传送门，城市 i 的传送门通往城市 a[i]。
* 当西西位于城市 i 时，每次他可以执行以下三种操作中的一种：

  花费 A 的费用，从城市 i 前往城市 a[i]；

  如果 a[i] > 1，可以花费 B 的费用，将 a[i] 的值减少 1；

  如果 a[i] < N，可以花费 C 的费用，将 a[i] 的值增加 1。

现在，西西想从城市 1 前往城市 N，那么他至少要花费多少费用？
* */
public class Main1 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        // 生成矩阵 和 数据
        int [][] data = new int[N][M];

        for (int i = 0; i < N; i++){

            for (int j = 0; j < M; j++){
                data[i][j] = ((i+1) * (j + 1)) % 10 ;
            }
        }

        // 滑动窗口
        long sum = 0;
        for (int y = 0; y < (M - B + 1); y++){

            for (int x = 0; x < (N - A + 1); x++){
                int max = 0;
                // 窗口求和

                // System.out.println(x + "  " +  " " + y) ;
                for (int i = y; i < (y + B ); i++){

                    for (int j = x; j < (x + A ); j++){

                        // System.out.println(i + "---" + j);
                        max = Math.max(data[j][i], max);
                    }
                }
                // System.out.println(max);
                sum += (long)max;
            }
        }

        System.out.println(sum);

    }
}
