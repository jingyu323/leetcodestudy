import java.util.Stack;

public class Invalidparen {

  public static void main(String[] args) {

     System.out.println(new Invalidparen().isValid(")"));



  }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character> ();
      for (char ch :s.toCharArray()){
          if(ch == '('){
              stack.push(ch);
          }
          if(ch == '['){
              stack.push(ch);
          }
          if(ch == '{'){
              stack.push(ch);
          }
          if(ch == ')'){

              if(stack.empty()){
                  return  false;
              }
              char top= stack.pop();
              if(top != '('){
                  return  false;
              }

          }
          if(ch == ']'){
              if(stack.empty()){
                  return  false;
              }
              char top= stack.pop();
              if(top != '['){
                  return  false;
              }
          }
          if(ch == '}'){
              if(stack.empty()){
                  return  false;
              }
              char top= stack.pop();
              if(top != '{'){
                  return  false;
              }
          }

      }
      if(!stack.empty()){
          return  false;
      }


      return  true;

    }
}
