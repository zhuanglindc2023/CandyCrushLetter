package org.lin.sample;

import org.junit.jupiter.api.Test;
import org.lin.sample.interfaces.IHandler;
import util.Element;
import util.Utility;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ReplacementHandlerTest {

    @Test
    void handle() {
        IHandler handler = new ReplacementHandler();

        //Case 1
        String inputStr = "aabbc";
        String outputStr = handler.handle(inputStr,2);
        String finalOutputStr = outputStr;
        assertAll(() -> assertEquals("ac", finalOutputStr));


        //Case 2
        inputStr = "aac";
        outputStr = handler.handle(inputStr,2);
        String finalOutputStr1 = outputStr;
        assertAll(() -> assertEquals("ac", finalOutputStr1));
    }

}