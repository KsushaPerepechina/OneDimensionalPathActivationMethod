package by.bsuir.onedimensionalpathactivationmethod.element.impl;

import by.bsuir.onedimensionalpathactivationmethod.element.CombinationalCircuitElement;
import by.bsuir.onedimensionalpathactivationmethod.element.ComputingElement;

import java.util.List;

public class DisparityElement extends ComputingElement {

    public DisparityElement(List<CombinationalCircuitElement> previousElements) {
        super(previousElements);
    }

    @Override
    public boolean compute() {
        boolean output = false;
        for (CombinationalCircuitElement element: super.getPreviousElements()) {
            output = output ^ element.compute();
        }
        return output;
    }

}
