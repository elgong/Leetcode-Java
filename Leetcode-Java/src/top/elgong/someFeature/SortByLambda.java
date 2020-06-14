package top.elgong.someFeature;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SortByLambda {

    public static void main(String[] args) {
        int[][] arr = new int[3][2];

        arr[0] = new int[]{1,2};
        arr[1] = new int[]{3,2};
        arr[2] = new int[]{2,2};

        // lambda 表达式
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        System.out.println(Arrays.toString(arr[0]));
        System.out.println(Arrays.toString(arr[1]));
        System.out.println(Arrays.toString(arr[2]));

        int[] arr2 = new int[]{3, 1, 2};

        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
    }
}
