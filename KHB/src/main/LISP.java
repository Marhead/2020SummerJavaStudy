/*
 * Name: Kim Hyun Bae
 * Student ID #: 2017145086
 */

/* 
 * Do NOT import any additional packages/classes.
 * If you (un)intentionally use some additional packages/classes we did not
 * provide, you may receive a 0 for the homework.
 */

public final class LISP implements ILISP {
    public IStack<Character> stack = new Stack<Character>();
    char current;
    char tmp;
    int length;

    public LISP() {

    }

    public boolean isLeft(char x){
        if(x == '('|| x == '{' || x == '['){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkBracketBalance(String expression) {

        length = expression.length();
        stack = new Stack<Character>();

        if(length == 0){
            return true;
        } else if(length%2 == 1){
            return false;
        } else {
            for(int i = 0; i<length; i++){
                current = expression.charAt(i);
                if(isLeft(current)){
                    stack.push(current);
                } else {
                     if(stack.size()==0){
                        return false;
                    }
                    
                     tmp = stack.pop();
                     if((tmp == '{' && current == '}')||(tmp == '[' && current == ']')||(tmp == '(' && current == ')')){
                        continue;
                     } else {
                        return false;
                     }
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
