package by.bsuir.onedimensionalpathactivationmethod.element;

import java.util.Set;

public abstract class ComputingElement implements CombinationalCircuitElement {

    private Set<CombinationalCircuitElement> previousElements;
    private CombinationalCircuitElement subsequentElement;

    public ComputingElement(Set<CombinationalCircuitElement> previousElements) {
        this.previousElements = previousElements;
    }

    public CombinationalCircuitElement getSubsequentElement() {
        return subsequentElement;
    }

    public void setSubsequentElement(CombinationalCircuitElement subsequentElement) {
        this.subsequentElement = subsequentElement;
    }

    public abstract boolean process(boolean ... input);

}
