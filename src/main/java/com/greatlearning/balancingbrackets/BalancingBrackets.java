package com.greatlearning.balancingbrackets;

import java.util.Stack;

public class BalancingBrackets {
    public static boolean balancedBrackets(String input){
        //business logic to find whether the given string has balanced brackets or not
        // insert all the opening brackets into the stack
        // for closing brackets pop from stack and check weather it matches with the one in stack

        Stack<Character> stack = new Stack<>();
        char[] ch = input.toCharArray();
        for(int i = 0;i<input.length();i++){
            char c = ch[i];
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if (c==')'){
                    char temp = stack.pop();
                    if (temp!='('){
                        return false;
                    }
                }else if (c=='}'){
                    char temp = stack.pop();
                    if (temp!='{'){
                        return false;
                    }
                }else if(c==']'){
                    char temp = stack.pop();
                    if (temp!='['){
                        return false;
                    }
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    public static void main (String[] args){

        // input string for determining if the brackets are balanced or not
        String inputStr = "( [ [ { } ] ] )";
        if (balancedBrackets(inputStr.trim())){
            System.out.println("The entered String has Balanced Brackets");
        }else{
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }
}
