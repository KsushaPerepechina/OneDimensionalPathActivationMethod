package by.bsuir.onedimensionalpathactivationmethod.circuit;

import by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl.ComputingElement;
import by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl.WireElement;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CombinationalCircuit {
    private static final String EMPTY_STRING = "";
    private static final String TRUE_STRING_REPRESENTATION = "1";
    private static final char ZERO_SYMBOL = '0';
    private List<WireElement> inputs;
    private ComputingElement outputElement;

    public boolean compute() {
        return outputElement.compute();
    }

    public List<Integer> getInputs() {
        return inputs.stream()
                .map(input -> {
                    if (input.getValue()) {
                        return 1;
                    } else {
                        return 0;
                    }
        }).collect(Collectors.toList());
    }

    public void setInputs(int decimalValue) {
        String binaryValue = Integer.toBinaryString(decimalValue);
        binaryValue = StringUtils.repeat(ZERO_SYMBOL, inputs.size() - binaryValue.length()) + binaryValue;
        String[] inputsArray = binaryValue.split(EMPTY_STRING);

        for (int index = 0; index < inputsArray.length; index++) {
            boolean value = TRUE_STRING_REPRESENTATION.equals(inputsArray[index]);
            inputs.get(index).setValue(value);
        }
    }

    public void setInputs(List<WireElement> inputs) {
        this.inputs = inputs;
    }

    public ComputingElement getOutputElement() {
        return outputElement;
    }

    public void setOutputElement(ComputingElement outputElement) {
        this.outputElement = outputElement;
    }

}
