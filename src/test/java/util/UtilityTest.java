package util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void convertStackToString() {

        Stack<Element> stack = new Stack<Element>();
        stack.push(new Element('a', 2));
        stack.push(new Element('b', 2));
        stack.push(new Element('c', 1));
        Assertions.assertEquals("aabbc",Utility.ConvertStackToString(stack));
    }

    @Test
    void readInputFromFile() {
        String filePath = "c:\\fake\\test.txt";
        String inputStr = Utility.readInputFromFile(filePath);
        assertEquals("", inputStr);
    }
}