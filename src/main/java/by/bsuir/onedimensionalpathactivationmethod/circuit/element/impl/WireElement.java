package by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl;

import by.bsuir.onedimensionalpathactivationmethod.circuit.element.CombinationalCircuitElement;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class WireElement implements CombinationalCircuitElement {
    private boolean value;

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean compute() {
        return value;
    }
}
