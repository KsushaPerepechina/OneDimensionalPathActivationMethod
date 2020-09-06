package by.bsuir.onedimensionalpathactivationmethod.element.impl;


import by.bsuir.onedimensionalpathactivationmethod.element.CombinationalCircuitElement;
import by.bsuir.onedimensionalpathactivationmethod.element.ComputingElement;

import java.util.List;

public class ConjunctionInvertionElement extends ComputingElement {

    public ConjunctionInvertionElement(List<CombinationalCircuitElement> previousElements) {
        super(previousElements);
    }

    @Override
    public boolean compute() {
        boolean output = true;
        for (CombinationalCircuitElement element: super.getPreviousElements()) {
            output = output && element.compute();
        }
        return !output;
    }
}
