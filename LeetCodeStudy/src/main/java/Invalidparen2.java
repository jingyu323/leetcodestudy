import java.util.HashMap;
import java.util.Stack;

public class Invalidparen2 {
    private HashMap<Character, Character> mappings;

    public Invalidparen2() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }



  public static void main(String[] args) {

     System.out.println(new Invalidparen2().isValid(")"));



  }

    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<Character> ();
      for (char ch :s.toCharArray()){
          if(mappings.containsKey(ch)){
              char topEle = stack.isEmpty() ? '#':stack.pop();
              //这里判断就是为了防止一个匹配就返回true
              if(topEle !=mappings.get(ch)){
                  return false;
              }
          }else{
              stack.push(ch);
          }
      }

      return  stack.isEmpty();

    }
}
