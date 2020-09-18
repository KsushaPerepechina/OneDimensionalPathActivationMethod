package by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl;

import by.bsuir.onedimensionalpathactivationmethod.circuit.element.CombinationalCircuitElement;

import java.util.List;

public class InvertionElement extends ComputingElement {
    private static final boolean FAULT_CONDITION = false;

    public InvertionElement(List<CombinationalCircuitElement> previousElements, int elementNumber) {
        super(previousElements, elementNumber);
    }


    @Override
    public boolean compute() {
        return !getPreviousElements().get(0).compute();
    }

    @Override
    public boolean getFaultCondition() {
        return FAULT_CONDITION;
    }

    @Override
    public boolean getPathActivityCondition() {
        throw new UnsupportedOperationException();
    }
}
