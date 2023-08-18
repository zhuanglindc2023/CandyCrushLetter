package org.lin.sample;

import org.junit.jupiter.api.Test;
import org.lin.sample.interfaces.IFactory;
import org.lin.sample.interfaces.IHandler;

import static org.junit.jupiter.api.Assertions.*;

class ReplacementFactoryTest {

    @Test
    void createHandler() {
        IFactory factory = new ReplacementFactory();
        IHandler handler = factory.createHandler();
        assertTrue(handler instanceof ReplacementHandler);
    }
}