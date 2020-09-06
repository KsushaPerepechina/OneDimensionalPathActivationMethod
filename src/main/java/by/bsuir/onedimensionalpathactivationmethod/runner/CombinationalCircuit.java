package by.bsuir.onedimensionalpathactivationmethod.runner;

import by.bsuir.onedimensionalpathactivationmethod.element.CombinationalCircuitElement;
import by.bsuir.onedimensionalpathactivationmethod.element.ComputingElement;
import by.bsuir.onedimensionalpathactivationmethod.element.WireElement;
import by.bsuir.onedimensionalpathactivationmethod.element.impl.ConjunctionElement;
import by.bsuir.onedimensionalpathactivationmethod.element.impl.ConjunctionInvertionElement;
import by.bsuir.onedimensionalpathactivationmethod.element.impl.DisjunctionElement;
import by.bsuir.onedimensionalpathactivationmethod.element.impl.DisjunctionInvertionElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationalCircuit {
    private CombinationalCircuitElement outputElement;

    public CombinationalCircuit() {
        config();
    }

    public boolean compute() {
        return outputElement.compute();
    }

    private void config() {
        WireElement[] inputs = {
                new WireElement(true),
                new WireElement(true),
                new WireElement(true),
                new WireElement(true),
                new WireElement(true),
                new WireElement(true),
                new WireElement(true)
        };

        ComputingElement f1 = new ConjunctionInvertionElement(new ArrayList<>(Arrays.asList(inputs[0], inputs[1])));
        ComputingElement f2 = new DisjunctionInvertionElement(new ArrayList<>(Collections.singletonList(inputs[2])));
        ComputingElement f3 = new DisjunctionInvertionElement(new ArrayList<>(Arrays.asList(inputs[4], inputs[5])));
        ComputingElement f4 = new ConjunctionElement(new ArrayList<>(Arrays.asList(inputs[3], f3, inputs[6])));
        ComputingElement f5 = new DisjunctionElement(new ArrayList<>(Arrays.asList(f2, f4)));
        ComputingElement f6 = new ConjunctionElement(new ArrayList<>(Arrays.asList(f1, f5)));

        f1.setSubsequentElement(f6);
        f2.setSubsequentElement(f5);
        f3.setSubsequentElement(f4);
        f4.setSubsequentElement(f5);
        f5.setSubsequentElement(f6);

        this.outputElement = f6;
    }
}
