package by.bsuir.onedimensionalpathactivationmethod.circuit;

import by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl.ComputingElement;
import by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl.WireElement;

public class CombinationalCircuit {
    private static final String EMPTY_STRING = "";
    private static final String TRUE_STRING_REPRESENTATION = "1";
    private WireElement[] inputs;
    private ComputingElement outputElement;

    public boolean compute() {
        return outputElement.compute();
    }

    public WireElement[] getInputs() {
        return inputs;
    }

    public void setInputs(WireElement[] inputs) {
        this.inputs = inputs;
    }

    public void setInputs(int decimalValue) {
        String binaryValue = Integer.toBinaryString(decimalValue);
        String[] inputs = binaryValue.split(EMPTY_STRING);
        for (int i = 0; i < inputs.length; i++) {
            boolean value = TRUE_STRING_REPRESENTATION.equals(inputs[i]);
            this.inputs[i].setValue(value);
        }
    }

    public ComputingElement getOutputElement() {
        return outputElement;
    }

    public void setOutputElement(ComputingElement outputElement) {
        this.outputElement = outputElement;
    }

    //TODO delete
    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("inputs", inputs)
                .append("outputElement", outputElement)
                .toString();
    }
}
