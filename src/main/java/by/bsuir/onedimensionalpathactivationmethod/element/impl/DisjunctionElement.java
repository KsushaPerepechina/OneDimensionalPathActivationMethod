package by.bsuir.onedimensionalpathactivationmethod.element.impl;

import by.bsuir.onedimensionalpathactivationmethod.element.CombinationalCircuitElement;
import by.bsuir.onedimensionalpathactivationmethod.element.ComputingElement;

import java.util.Set;

public class DisjunctionElement extends ComputingElement {

    public DisjunctionElement(Set<CombinationalCircuitElement> previousElements) {
        super(previousElements);
    }

    public boolean process(boolean... input) {
        boolean output = false;
        for (boolean x: input) {
            output = output || x;
        }
        return output;
    }

}
