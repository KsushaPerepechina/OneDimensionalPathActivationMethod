package by.bsuir.onedimensionalpathactivationmethod.config;

import by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl.*;
import by.bsuir.onedimensionalpathactivationmethod.circuit.CombinationalCircuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationalCircuitConfigurer {
    public void configCircuit(CombinationalCircuit combinationalCircuit) {
        List<WireElement> inputs = createInputs();
        combinationalCircuit.setInputs(inputs);

        ComputingElement outputElement = configElements(inputs);
        combinationalCircuit.setOutputElement(outputElement);
    }

    private List<WireElement> createInputs() {
        return new ArrayList<WireElement>() {
            {
                add(new WireElement());
                add(new WireElement());
                add(new WireElement());
                add(new WireElement());
                add(new WireElement());
                add(new WireElement());
                add(new WireElement());
            }
        };
    }

    private ComputingElement configElements(List<WireElement> inputs) {
        ComputingElement f1 = new ConjunctionInvertionElement(new ArrayList<>(Arrays.asList(inputs.get(0), inputs.get(1))), 1);
        ComputingElement f2 = new InvertionElement(new ArrayList<>(Collections.singletonList(inputs.get(2))), 2);
        ComputingElement f3 = new DisjunctionInvertionElement(new ArrayList<>(Arrays.asList(inputs.get(4), inputs.get(5))), 3);
        ComputingElement f4 = new ConjunctionElement(new ArrayList<>(Arrays.asList(inputs.get(3), f3, inputs.get(6))), 4);
        ComputingElement f5 = new DisjunctionElement(new ArrayList<>(Arrays.asList(f2, f4)), 5);
        ComputingElement f6 = new ConjunctionElement(new ArrayList<>(Arrays.asList(f1, f5)), 6);

        f1.setSubsequentElement(f6);
        f2.setSubsequentElement(f5);
        f3.setSubsequentElement(f4);
        f4.setSubsequentElement(f5);
        f5.setSubsequentElement(f6);

        return f6;
    }
}
