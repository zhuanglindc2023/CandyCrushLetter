package org.lin.sample;

import org.lin.sample.interfaces.IHandler;
import org.lin.sample.interfaces.IFactory;

public class DeduplicationFactory implements IFactory {

    @Override
    public IHandler createHandler() {
        return new DeduplicationHandler();
    }
}
