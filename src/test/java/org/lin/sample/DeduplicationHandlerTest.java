package org.lin.sample;

import org.junit.jupiter.api.Test;
import org.lin.sample.interfaces.IHandler;
import util.Element;
import util.Utility;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DeduplicationHandlerTest {

    @Test
    void handle() {
        IHandler handler = new DeduplicationHandler();
        String inputStr = "aabbc";
        String outputStr = handler.handle(inputStr,2);
        assertAll(() -> assertEquals("c", outputStr));
    }
}