package org.lin.sample;

import org.lin.sample.interfaces.IHandler;
import util.Element;
import util.Utility;

import java.util.Stack;

public class DeduplicationHandler implements IHandler {

    /**
     * This function is used for removing consecutive characters from an input string.
     * @param inputStr the string need to handle
     * @param cnt the number of consecutive chars
     */
    @Override
    public String handle(String inputStr, int cnt) {
        //A sample case that consecutive count = 1
        if (cnt == 1) {
            return "";
        }

        //initialize a stack to count the duplications.
        Stack<Element> stack = new Stack<Element>();

        int len = inputStr.length();

        for(int i = 0; i < len; i++) {

            // if the stack is empty, need to add the first char into stack
            // and the duplication count to be 1
            if (stack.isEmpty()) {
                Element elt = new Element(inputStr.charAt(i), 1);
                stack.push(elt);
                continue;
            }

            //if the top char in stack is the same as char from string loop
            //then the top char will increase the duplication count.
            if (stack.peek().getValue() == inputStr.charAt(i))
            {
                Element p = stack.peek();
                stack.pop();
                p.setCount(p.getCount() + 1);
                stack.push(p);
            } else {
                int repeat = 0;
                while (!stack.isEmpty() && stack.peek().getCount() >= cnt) {
                    stack.pop();
                    String tmpOutput = Utility.ConvertStackToString(stack) +
                            inputStr.substring(i + repeat);
                    System.out.println("-> "+ tmpOutput);
                    repeat ++;
                }
                if (!stack.isEmpty() && stack.peek().getValue() == inputStr.charAt(i)) {
                    Element p = stack.peek();
                    stack.pop();
                    p.setCount(p.getCount() + 1);
                    stack.push(p);
                } else {
                    stack.push(new Element(inputStr.charAt(i), 1));
                }
            }
            if (i == len-1) {
                if (!stack.isEmpty() && stack.peek().getCount() >= cnt) {
                    stack.pop();
                    System.out.println("-> "+ Utility.ConvertStackToString(stack));
                }
            }
        }

        //completed the de-duplication, and prepare for the output
        //by popping out from the stack.
        String outputStr = Utility.ConvertStackToString(stack);
        return outputStr;
    }
}
