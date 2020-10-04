/*
* Name: Kim Hyun Bae
* Student ID #:2017145086
*/

/*
* Do NOT import any additional packages/classes.
* If you (un)intentionally use some additional packages/classes we did not
* provide, you may receive a 0 for the homework.
*/

public class PostfixCalc implements ICalc {
    public IStack<Integer> stack;
    String[] arr;
    String tmp;
    int value;

    public PostfixCalc() {
        this.stack = new Stack<>();
    }

    public boolean isOperator(String input){
       char x = input.charAt(0);
        if(x == '+' || x == '-' || x == '*'){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int evaluate(String expression) {
        
        this.stack = new Stack<>();
        arr = expression.split(" ");

        for(int i=0; i<arr.length; i++){
            if(!isOperator(arr[i])){
                stack.push(Integer.parseInt(arr[i]));
            } else {
                value = stack.pop();
                if(arr[i].charAt(0) == '+'){
                    value += stack.pop();
                } else if(arr[i].charAt(0) == '-'){
                    value = stack.pop() - value;
                } else {
                    value *= stack.pop();
                }
                stack.push(value);
            }
        }

        return stack.pop();
    }
}