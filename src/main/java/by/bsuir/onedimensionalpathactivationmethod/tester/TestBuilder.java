package by.bsuir.onedimensionalpathactivationmethod.tester;

import by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl.ComputingElement;
import by.bsuir.onedimensionalpathactivationmethod.circuit.CombinationalCircuit;

import java.util.stream.IntStream;

public class TestBuilder {

    public void buildAllTests(CombinationalCircuit combinationalCircuit) {
        int number = (int) (Math.pow(2, combinationalCircuit.getInputs().length) - 1);
        IntStream.range(0, number).forEach(num -> {
            combinationalCircuit.setInputs(num);
            if (buildTest(combinationalCircuit.getOutputElement())) {
                System.out.println(Integer.toBinaryString(num));
            }
        });
    }

    public boolean buildTest(ComputingElement element) {
        return element.compute();
//        boolean output = element.getSubsequentElement().compute();
//        return input == element.getFaultCondition() && output == element.getSubsequentElement().getPathActivityCondition();
    }

}
