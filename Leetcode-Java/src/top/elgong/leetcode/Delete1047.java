
package top.elgong.leetcode;
import java.util.LinkedList;

public class Delete1047 {

	public static void main(String[] args) {
		
		String S = "abbaca";
	
		 // 双指针法
        char[] chArr = new char[S.length()];
        
        int index = 0;
        for(int i=0; i<S.length(); i++){
            if(index==0){
                chArr[index] = S.charAt(i);
            }else if(chArr[index] != S.charAt(i)){
                chArr[++index] = S.charAt(i);
            }else{
                index--;
            }
        }
        System.out.println(new String(chArr,0, index+1));
        
	}

}


//利用栈
class Solution_1047 {
 public String removeDuplicates(String S) {

     // 栈
     LinkedList<Character> stack = new LinkedList<Character>();

     for(int i=0; i<S.length(); i++){
         if(stack.size() == 0){
             stack.push(S.charAt(i));
         }else if(stack.peek() == S.charAt(i)){
             stack.pop();
         }else{
             stack.push(S.charAt(i));
         }
     }

     StringBuilder sb = new StringBuilder("");
     while(stack.size() != 0){
         sb.append(stack.removeLast());
     }

     return new String(sb);
 }
}

