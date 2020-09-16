package by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl;

import by.bsuir.onedimensionalpathactivationmethod.circuit.element.CombinationalCircuitElement;

import java.util.List;

public class DisjunctionInvertionElement extends ComputingElement {
    private static final boolean FAULT_CONDITION = false;
    private static final boolean PATH_ACTIVITY_CONDITION = false;

    public DisjunctionInvertionElement(List<CombinationalCircuitElement> previousElements) {
        super(previousElements);
    }

    @Override
    public boolean compute() {
        boolean output = false;
        for (CombinationalCircuitElement element: super.getPreviousElements()) {
            output = output || element.compute();
        }
        return !output;
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
