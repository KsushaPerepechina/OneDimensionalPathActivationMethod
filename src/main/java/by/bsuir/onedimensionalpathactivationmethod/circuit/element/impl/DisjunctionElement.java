package by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl;

import by.bsuir.onedimensionalpathactivationmethod.circuit.element.CombinationalCircuitElement;

import java.util.List;

public class DisjunctionElement extends ComputingElement {
    private static final boolean FAULT_CONDITION = true;
    private static final boolean PATH_ACTIVITY_CONDITION = false;

    public DisjunctionElement(List<CombinationalCircuitElement> previousElements, int elementNumber) {
        super(previousElements, elementNumber);
    }


    @Override
    public boolean compute() {
        boolean output = false;
        for (CombinationalCircuitElement element: super.getPreviousElements()) {
            output = output || element.compute();
        }
        return output;
    }

    @Override
    public boolean getFaultCondition() {
        return FAULT_CONDITION;
    }

    @Override
    public boolean getPathActivityCondition() {
        return PATH_ACTIVITY_CONDITION;
    }
}
