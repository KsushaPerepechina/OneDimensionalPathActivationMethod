package by.bsuir.onedimensionalpathactivationmethod.config;

import by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl.*;
import by.bsuir.onedimensionalpathactivationmethod.circuit.CombinationalCircuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationalCircuitConfigurer {
    public void configCircuit(CombinationalCircuit combinationalCircuit) {
        WireElement[] inputs = createInputs();
        combinationalCircuit.setInputs(inputs);

        ComputingElement outputElement = configElements(inputs);
        combinationalCircuit.setOutputElement(outputElement);
    }

    private WireElement[] createInputs() {
        return new WireElement[]{
                new WireElement(),
                new WireElement(),
                new WireElement(),
                new WireElement(),
                new WireElement(),
                new WireElement(),
                new WireElement()
        };
    }

    private ComputingElement configElements(WireElement[] inputs) {
        ComputingElement f1 = new ConjunctionInvertionElement(new ArrayList<>(Arrays.asList(inputs[0], inputs[1])));
        ComputingElement f2 = new InvertionElement(new ArrayList<>(Collections.singletonList(inputs[2])));
        ComputingElement f3 = new DisjunctionInvertionElement(new ArrayList<>(Arrays.asList(inputs[4], inputs[5])));
        ComputingElement f4 = new ConjunctionElement(new ArrayList<>(Arrays.asList(inputs[3], f3, inputs[6])));
        ComputingElement f5 = new DisjunctionElement(new ArrayList<>(Arrays.asList(f2, f4)));
        ComputingElement f6 = new ConjunctionElement(new ArrayList<>(Arrays.asList(f1, f5)));

        f1.setSubsequentElement(f6);
        f2.setSubsequentElement(f5);
        f3.setSubsequentElement(f4);
        f4.setSubsequentElement(f5);
        f5.setSubsequentElement(f6);

        return f6;
    }
}
