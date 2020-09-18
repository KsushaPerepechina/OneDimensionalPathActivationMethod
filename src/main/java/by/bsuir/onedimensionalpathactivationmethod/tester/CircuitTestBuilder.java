package by.bsuir.onedimensionalpathactivationmethod.tester;

import by.bsuir.onedimensionalpathactivationmethod.circuit.element.CombinationalCircuitElement;
import by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl.ComputingElement;
import by.bsuir.onedimensionalpathactivationmethod.circuit.CombinationalCircuit;
import by.bsuir.onedimensionalpathactivationmethod.printer.TestConsolePrinter;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CircuitTestBuilder {
    private CombinationalCircuit circuit;
    private TestConsolePrinter printer;

    public CircuitTestBuilder(CombinationalCircuit circuit) {
        this.circuit = circuit;
        this.printer = new TestConsolePrinter(circuit);
    }

    public void execute() {
        System.out.println("Tests assuming constant 0");
        buildTestsForCircuit(circuit.getOutputElement(), true);
        System.out.println("Tests assuming constant 1");
        buildTestsForCircuit(circuit.getOutputElement(), false);
    }

    private void buildTestsForCircuit(ComputingElement element, boolean constant) {
        for (CombinationalCircuitElement previous : element.getPreviousElements()) {
            if (previous instanceof ComputingElement) {
                buildTestsForCircuit((ComputingElement) previous, constant);
            }
        }

        int number = (int) (Math.pow(2, circuit.getInputs().size()));
        printer.printHeader(element);
        IntStream.range(0, number).forEach(num -> {
            circuit.setInputs(num);
            buildTestsForElement(element, constant);
        });
    }

    private void buildTestsForElement(ComputingElement element, boolean constant) {
        boolean currentElementCondition;
        if (constant) {
            currentElementCondition = element.compute() == element.getFaultCondition();
        } else {
            currentElementCondition = element.compute() == !element.getFaultCondition();
        }
        boolean parallelElementsCondition = true;
        if (element.getSubsequentElement() != null) {
            parallelElementsCondition = defineParallelElementsCondition(element, true);
        }
        if (currentElementCondition && parallelElementsCondition) {
            printer.printRow();
        }
    }

    private boolean defineParallelElementsCondition(ComputingElement element, boolean result) {
        ComputingElement subsequentElement = element.getSubsequentElement();
        if (subsequentElement.getSubsequentElement() != null) {
            result = defineParallelElementsCondition(subsequentElement, result);
        }

        boolean condition = subsequentElement.getPreviousElements()
                .stream()
                .filter(el -> el != element)
                .allMatch(item -> item.compute() == subsequentElement.getPathActivityCondition());
        if (!condition) {
            result = false;
        }
        return result;
    }
}