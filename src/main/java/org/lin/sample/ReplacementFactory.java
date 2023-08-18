package org.lin.sample;

import org.lin.sample.interfaces.IFactory;
import org.lin.sample.interfaces.IHandler;

public class ReplacementFactory implements IFactory {
    @Override
    public IHandler createHandler() {
        return new ReplacementHandler();
    }
}
