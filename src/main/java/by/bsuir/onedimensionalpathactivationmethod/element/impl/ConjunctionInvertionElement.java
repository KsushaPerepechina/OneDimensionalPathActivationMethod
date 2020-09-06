package by.bsuir.onedimensionalpathactivationmethod.element.impl;


import by.bsuir.onedimensionalpathactivationmethod.element.CombinationalCircuitElement;
import by.bsuir.onedimensionalpathactivationmethod.element.ComputingElement;

import java.util.Set;

public class ConjunctionInvertionElement extends ComputingElement {

    public ConjunctionInvertionElement(Set<CombinationalCircuitElement> previousElements) {
        super(previousElements);
    }

    public boolean process(boolean... input) {
        boolean output = true;
        for (boolean x: input) {
            output = output && x;
        }
        return !output;
    }
}
