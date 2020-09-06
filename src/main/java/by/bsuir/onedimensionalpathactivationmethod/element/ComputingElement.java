package by.bsuir.onedimensionalpathactivationmethod.element;


import java.util.List;

public abstract class ComputingElement implements CombinationalCircuitElement {

    private List<CombinationalCircuitElement> previousElements;
    private CombinationalCircuitElement subsequentElement;

    public ComputingElement(List<CombinationalCircuitElement> previousElements) {
        this.previousElements = previousElements;
    }

    public CombinationalCircuitElement getSubsequentElement() {
        return subsequentElement;
    }

    public void setSubsequentElement(CombinationalCircuitElement subsequentElement) {
        this.subsequentElement = subsequentElement;
    }

    public List<CombinationalCircuitElement> getPreviousElements() {
        return previousElements;
    }

    public void setPreviousElements(List<CombinationalCircuitElement> previousElements) {
        this.previousElements = previousElements;
    }

}
