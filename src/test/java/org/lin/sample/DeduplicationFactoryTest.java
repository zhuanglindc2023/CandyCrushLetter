package org.lin.sample;

import org.junit.jupiter.api.Test;
import org.lin.sample.interfaces.IFactory;
import org.lin.sample.interfaces.IHandler;
import util.Utility;

import static org.junit.jupiter.api.Assertions.*;

class DeduplicationFactoryTest {

    @Test
    void create() {
        IFactory factory = new DeduplicationFactory();
        IHandler handler = factory.createHandler();
        assertTrue(handler instanceof DeduplicationHandler);
    }
}