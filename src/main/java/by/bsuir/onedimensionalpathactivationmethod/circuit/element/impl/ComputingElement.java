package by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl;


import by.bsuir.onedimensionalpathactivationmethod.circuit.element.CombinationalCircuitElement;

import java.util.List;

public abstract class ComputingElement implements CombinationalCircuitElement {
    private List<CombinationalCircuitElement> previousElements;
    private ComputingElement subsequentElement;
    private int number;

    public ComputingElement(List<CombinationalCircuitElement> previousElements, int number) {
        this.previousElements = previousElements;
        this.number = number;
    }

    public ComputingElement getSubsequentElement() {
        return subsequentElement;
    }

    public void setSubsequentElement(ComputingElement subsequentElement) {
        this.subsequentElement = subsequentElement;
    }

    public List<CombinationalCircuitElement> getPreviousElements() {
        return previousElements;
    }

    public abstract boolean getFaultCondition();

    public abstract boolean getPathActivityCondition();

    public int getNumber() {
        return number;
    }
}
