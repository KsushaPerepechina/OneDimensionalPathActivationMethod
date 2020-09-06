package by.bsuir.onedimensionalpathactivationmethod.element.impl;

import by.bsuir.onedimensionalpathactivationmethod.element.CombinationalCircuitElement;
import by.bsuir.onedimensionalpathactivationmethod.element.ComputingElement;

import java.util.Set;

public class InvertionElement extends ComputingElement {

    public InvertionElement(Set<CombinationalCircuitElement> previousElements) {
        super(previousElements);
    }

    public boolean process(boolean... input) {
        return !input[0];
    }

}
