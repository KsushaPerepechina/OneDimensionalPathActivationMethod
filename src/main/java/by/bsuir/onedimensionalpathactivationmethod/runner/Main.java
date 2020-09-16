package by.bsuir.onedimensionalpathactivationmethod.runner;

import by.bsuir.onedimensionalpathactivationmethod.circuit.CombinationalCircuit;
import by.bsuir.onedimensionalpathactivationmethod.config.CombinationalCircuitConfigurer;
import by.bsuir.onedimensionalpathactivationmethod.tester.TestBuilder;

public class Main {

    public static void main(String[] args) {
        CombinationalCircuit combinationalCircuit = new CombinationalCircuit();

        CombinationalCircuitConfigurer configurer = new CombinationalCircuitConfigurer();
        configurer.configCircuit(combinationalCircuit);

        TestBuilder testBuilder = new TestBuilder();
        testBuilder.buildAllTests(combinationalCircuit);
    }
}
