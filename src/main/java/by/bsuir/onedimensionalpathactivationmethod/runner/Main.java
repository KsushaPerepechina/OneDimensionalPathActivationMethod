package by.bsuir.onedimensionalpathactivationmethod.runner;

import by.bsuir.onedimensionalpathactivationmethod.element.*;
import by.bsuir.onedimensionalpathactivationmethod.element.impl.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    private void CombinationalCircuit() {
        WireElement[] inputs = {
                new WireElement(),
                new WireElement(),
                new WireElement(),
                new WireElement(),
                new WireElement(),
                new WireElement(),
                new WireElement()
        };

        ComputingElement f1 = new ConjunctionInvertionElement(new HashSet<>(Arrays.asList(inputs[0], inputs[1])));
        ComputingElement f2 = new DisjunctionInvertionElement(new HashSet<>(Collections.singleton(inputs[2])));
        ComputingElement f3 = new DisjunctionInvertionElement(new HashSet<>(Arrays.asList(inputs[4], inputs[5])));
        ComputingElement f4 = new ConjunctionElement(new HashSet<>(Arrays.asList(inputs[3], f3, inputs[6])));
        ComputingElement f5 = new DisjunctionElement(new HashSet<>(Arrays.asList(f2, f4)));
        ComputingElement f6 = new ConjunctionElement(new HashSet<>(Arrays.asList(f1, f5)));

        f1.setSubsequentElement(f6);
        f2.setSubsequentElement(f5);
        f3.setSubsequentElement(f4);
        f4.setSubsequentElement(f5);
        f5.setSubsequentElement(f6);
    }

}
