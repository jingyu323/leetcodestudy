import java.util.HashMap;
import java.util.Stack;

public class Invalidparen3 {



  public static void main(String[] args) {

     System.out.println(new Invalidparen3().isValid("{}{}{})"));

  }

    public boolean isValid(String s) {
      char[] stack = new char[s.length()+1]; //就是为了--top的时候不出现stack 越界
      int top =1;
      for (char c :s.toCharArray()){
          if (c == '(' || c == '[' || c == '{') {
              stack[top++] = c;//进栈
          }else if((c == ')' && stack[--top] != '(') || (c == ']' && stack[--top] != '[') || (c == '}' && stack[--top] != '{')){
            return false;
          }
      }
      return top ==1;
    }
}
