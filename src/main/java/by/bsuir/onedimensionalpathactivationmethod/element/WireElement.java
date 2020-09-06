package by.bsuir.onedimensionalpathactivationmethod.element;

public class WireElement implements CombinationalCircuitElement {

    private boolean value;

    public WireElement(boolean value) {
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean compute() {
        return value;
    }
}
