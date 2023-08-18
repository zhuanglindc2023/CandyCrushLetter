package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Utility {
    public enum HANDLER_TYPE {
        DEDUPLICATION,
        REPLACEMENT
    }

    /**
     * This is a function to convert from a stack to a string with characters .
     * @param stack the stack to convert
     * @return  the converted string
     */
    public static String ConvertStackToString(Stack<Element> stack) {
        StringBuilder output = new StringBuilder();
        Element[] itemList = new Element[stack.size()];
        stack.copyInto(itemList);
        for (Element element : itemList) {
            char value = element.getValue();
            int dupCount = element.getCount();
            while (dupCount-- > 0) {
                output.append(value);
            }
        }
        return output.toString();
    }

    /**
     * This is a function to read characters from a patch of a file.
     * @param filename the file path
     * @return  the string read from file
     */
    public static String readInputFromFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.printf(e.toString());
        }
        if (sb.toString().matches("^[a-z]]*$")) {
            System.out.println("There are invalid characters from the input file. Please try again!");
            return null;
        } else {
            System.out.println("The input string from file is: " + sb.toString());
        }
        return sb.toString();
    }
}

