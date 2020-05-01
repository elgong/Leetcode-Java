package top.elgong.testOnline;

import java.util.*;

public class Main2 {
    private  static Set<String> set = new HashSet<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> res = new ArrayList<>();

        //while (sc.hasNext()){
            String line = sc.nextLine();
            if (line == null || line.length() == 0){
                System.out.println(0);
                //continue;
                return;
            }
            char[] charArray = line.toCharArray();

            int[] log = new int[charArray.length];

            dfs(charArray, 0, log, new StringBuilder(), res);

            System.out.println(set.size());
        }


   // }

    private static void dfs(char[] arr, int depth, int[] log, StringBuilder sb,  List<String> arrList){

        if (depth >= arr.length){

            set.add(new String(sb));
            return;
        }

        for (int i = 0; i < arr.length; i++){

            if (log[i] == 1){
                continue;
            }

            log[i] = 1;
            sb.append(arr[i]);
            dfs(arr, depth + 1, log, sb, arrList);
            sb.deleteCharAt(sb.length() - 1);
            log[i] = 0;
        }
    }
}
