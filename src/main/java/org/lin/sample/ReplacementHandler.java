package org.lin.sample;

import org.lin.sample.interfaces.IHandler;
import util.Element;
import util.Utility;

import java.util.Stack;

public class ReplacementHandler implements IHandler {

    private Element replace(Element item) {
//        Element itemToConvert = stack.peek();
//        char targetValue = (char)(itemToConvert.getValue()-1);
//        targetValue = targetValue < 'a' ? 'a' : targetValue;
//        if (stack.peek().getValue() == targetValue) {
//            stack.peek().setCount(stack.peek().getCount()+1);
//        } else {
//            itemToConvert.setValue(targetValue);
//            itemToConvert.setCount(1);
//            stack.push(itemToConvert);
//        }
        char targetValue = (char)(item.getValue()-1);
        targetValue = targetValue < 'a' ? 'a' : targetValue;
        item.setValue(targetValue);
        item.setCount(1);
        return item;
    }

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
            //if the input char is the same as the top of stack.
            //increase the count of duplications.
            if (stack.peek().getValue() == inputStr.charAt(i))
            {
                Element p = stack.peek();
                stack.pop();
                p.setCount(p.getCount() + 1);
                stack.push(p);
            } else {
                //if the duplication count reach the duplication level,
                //initialize a temp stack to de-duplicate the character.
                if (stack.peek().getCount() >= cnt) {
                    Stack<Element> tempStack = new Stack<Element>();
                    //push new value from inputStr
                    tempStack.push(new Element(inputStr.charAt(i),1));
                    Element itemToReplace = replace(stack.pop());
                    //Push the value has been replaced
                    stack.push(itemToReplace);

                    //Push duplicate value to new temp stack
                    while (stack.peek().getValue() == tempStack.peek().getValue()) {
                        Element from_peak = stack.pop();
                        tempStack.peek().setCount(from_peak.getCount()+tempStack.peek().getCount());
                    }
                    //Push duplicate value back to main stack
                    while (!tempStack.isEmpty()) {
                        stack.push(tempStack.pop());
                    }
                    String tmpOutput = Utility.ConvertStackToString(stack) +
                            inputStr.substring(i+1);
                    System.out.println("-> "+ tmpOutput);
                } else {
                    stack.push(new Element(inputStr.charAt(i), 1));
                }
            }
            //at the last step of loop,
            // use a temp stack to deduplicate the remaining consecutive characters
            if (i == len - 1) {
                Stack<Element> tempStack = new Stack<Element>();
                if (!stack.isEmpty()) {
                    int repeat = 0;
                    do {
                        repeat = 0;
                        tempStack.push(stack.pop());
                        while (!stack.isEmpty()) {
                            if (stack.peek().getValue() == tempStack.peek().getValue()) {
                                Element toPeak = tempStack.peek();
                                toPeak.setCount(toPeak.getCount() + stack.pop().getCount());
                                if (toPeak.getCount() >= cnt) {
                                    repeat =toPeak.getCount();
                                    replace(toPeak);
                                }
                            } else {
                                tempStack.push(stack.pop());
                            }
                        }
                        while (!tempStack.isEmpty()) {
                            int fromPeakCnt = tempStack.peek().getCount();

                            stack.push(tempStack.pop());
                        }
                    } while (repeat >= cnt);
                }
            }
        }

        //consolidate the output from stack
        String outputStr = Utility.ConvertStackToString(stack);
        return outputStr;
    }
}
