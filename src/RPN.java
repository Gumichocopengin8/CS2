import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class RPN {
  public static void main(String[] args) {
    String eqn = "8 / 6 + 6"; // 6 / 2 * (1 + 2)
    String[] rpn =  RPN_Convert(RPN_Cast(eqn));
    for (String i : rpn) {
      System.out.print(i + ", ");
    }
    System.out.println("\n" + RPN_Calc(rpn));
  }

  private static String[] RPN_Convert(String[] eqnList) {
    ArrayList<String> result = new ArrayList<>();
    Deque<String> stack = new ArrayDeque<>();
    for(String token : eqnList){
      switch (token) {
        case "+":
        case "-":
          while(!stack.isEmpty()) {
            String str = stack.getFirst();
            if(str.equals("^")) {
              result.add(stack.removeFirst());
            } else if(str.equals("*") || str.equals("/")) {
              result.add(stack.removeFirst());
            } else {
              break;
            }
          }
          stack.addFirst(token);
          break;
        case "*":
        case "/":
          while(!stack.isEmpty()) {
            String str = stack.getFirst();
            if(str.equals("^")) {
              result.add(stack.removeFirst());
            } else if(str.equals("*") || str.equals("/")) {
              result.add(stack.removeFirst());
            } else {
              break;
            }
          }
          stack.addFirst(token);
          break;
        case "^":
          stack.addFirst(token);
          break;
        case "(":
          stack.addFirst(token);
          break;
        case ")":
          List<Object> list = Arrays.asList(stack.toArray());
          int index = list.indexOf("(");

          Deque<String> workStack = new ArrayDeque<>();
          for(int i = 0; i <= index; i++){
            String str = stack.removeFirst();
            if (!str.equals("(")) {
              workStack.add(str);
            }
          }
          while(!workStack.isEmpty()){
            result.add(workStack.removeFirst());
          }
          break;
        default:
          result.add(token);
          break;
      }
    }
    while(!stack.isEmpty()){
      result.add(stack.removeFirst());
    }
    return result.toArray(new String[result.size()]);
  }

  public static String RPN_Calc(String[] eqn) {
    Stack<BigDecimal> que = new Stack<>();
    BigDecimal a;
    BigDecimal b;
    try {
      for (String token : eqn) {
        switch (token) {
          case "+":
            a = que.pop();
            b = que.pop();
            que.add(b.add(a));
            break;
          case "-":
            a = que.pop();
            b = que.pop();
            que.add(b.subtract(a));
            break;
          case "*":
            a = que.pop();
            b = que.pop();
            que.add(b.multiply(a));
            break;
          case "/":
            a = que.pop();
            b = que.pop();
            que.add(b.divide(a));
            break;
          case "^":
            a = que.pop();
            b = que.pop();
            que.add(b.pow(a.intValue()));
            break;
          default:
            que.push(new BigDecimal(token));
        }
      }
    } catch (ArithmeticException e) {
      System.out.println(e.getMessage());
      return "Math Error";
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return "Error";
    }
    return que.pop().stripTrailingZeros().toPlainString();
  }

  private static String[] RPN_Cast(String original) { // @ can be anything except operator sign
    original = original.replace("×", "*").replace("÷", "/");
    String eqn = original.replace("(", "(@").replace(")", "@)");
    return eqn.split("[ @]", 0);
  }
}
