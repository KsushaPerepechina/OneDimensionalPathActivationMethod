package by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl;


import by.bsuir.onedimensionalpathactivationmethod.circuit.element.CombinationalCircuitElement;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public abstract class ComputingElement implements CombinationalCircuitElement {
    private List<CombinationalCircuitElement> previousElements;
    private ComputingElement subsequentElement;

    public ComputingElement(List<CombinationalCircuitElement> previousElements) {
        this.previousElements = previousElements;
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

    public void setPreviousElements(List<CombinationalCircuitElement> previousElements) {
        this.previousElements = previousElements;
    }

    public abstract boolean getFaultCondition();

    public abstract boolean getPathActivityCondition();

    //TODO delete
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("previousElements: ", previousElements)
                .append("subsequentElement: ", subsequentElement)
                .toString();
    }
}
