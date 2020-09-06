package by.bsuir.onedimensionalpathactivationmethod.element.impl;

import by.bsuir.onedimensionalpathactivationmethod.element.CombinationalCircuitElement;
import by.bsuir.onedimensionalpathactivationmethod.element.ComputingElement;

import java.util.Set;

public class DisparityElement extends ComputingElement {

    public DisparityElement(Set<CombinationalCircuitElement> previousElements) {
        super(previousElements);
    }

    public boolean process(boolean... input) {
        boolean output = false;
        for (boolean x: input) {
            output = output ^ x;
        }
        return output;
    }

}
