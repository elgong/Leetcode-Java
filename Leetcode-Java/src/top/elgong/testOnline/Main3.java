package top.elgong.testOnline;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String line = in.nextLine();
            StringBuilder sb = new StringBuilder(line);
            int b = Integer.parseInt(in.nextLine());
            if (line.length() == 0 || b <= 0){
                System.out.println(line);
                continue;
            }

            int first = 0;
            int second = 1;
            while (b-- > 0){
                first = 0;
                second = 1;
                if (second >= sb.length()){
                    System.out.println(sb.toString());
                    break;
                }
                if (sb.charAt(first) > sb.charAt(second)){
                    sb.deleteCharAt(first);
                }else if (sb.charAt(first) < sb.charAt(second)){
                    // 找到更大的
                    char tmp = sb.charAt(second);
                    int tmpIndex = second;
                    while (tmpIndex < sb.length() && sb.charAt(tmpIndex) >= tmp){
                        tmp = sb.charAt(tmpIndex);
                        tmpIndex++;
                    }

                    if (second == tmpIndex){
                        sb.deleteCharAt(second);
                    }else{
                        sb.deleteCharAt(--tmpIndex);
                    }

                }else{

                    char tmp = sb.charAt(second);
                    int tmpIndex = second;
                    while (tmpIndex < sb.length() && sb.charAt(tmpIndex) == tmp){
                        tmpIndex++;
                    }
                    if (tmpIndex >= sb.length() ){
                        sb.deleteCharAt(second);
                    } else if (sb.charAt(tmpIndex) < tmp){
                        sb.deleteCharAt(first);
                    }else {
                        tmp = sb.charAt(tmpIndex);
                        while (tmpIndex < sb.length() && sb.charAt(tmpIndex) >= tmp){

                            tmpIndex++;
                        }

                        sb.deleteCharAt(--tmpIndex);

                    }
                }
            }

            System.out.println(sb.toString());

        }
    }


}