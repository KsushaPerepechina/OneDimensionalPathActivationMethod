package by.bsuir.onedimensionalpathactivationmethod.printer;

import by.bsuir.onedimensionalpathactivationmethod.circuit.CombinationalCircuit;
import by.bsuir.onedimensionalpathactivationmethod.circuit.element.impl.ComputingElement;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

public class TestConsolePrinter {
    private static final char DASH_SYMBOL = '-';
    private static final char VERTICAL_BAR_SYMBOL = '|';
    private static final char COLON_SYMBOL = ':';
    private static final char SPACE_SYMBOL = ' ';
    private static final char NEW_LINE_SYMBOL = '\n';
    private static final char UPPERCASE_F_LETTER = 'F';
    private static final char LOWERCASE_X_SYMBOL = 'x';
    private CombinationalCircuit circuit;

    public TestConsolePrinter(CombinationalCircuit circuit) {
        this.circuit = circuit;
    }

    public void printHeader(ComputingElement element) {
        StringBuilder headerBuilder = new StringBuilder();
        headerBuilder
                .append(UPPERCASE_F_LETTER)
                .append(element.getNumber())
                .append(COLON_SYMBOL)
                .append(NEW_LINE_SYMBOL)
                .append(SPACE_SYMBOL)
                .append(StringUtils.repeat(DASH_SYMBOL, circuit.getInputs().size() * 3 - 1))
                .append(NEW_LINE_SYMBOL);
        IntStream.range(1, circuit.getInputs().size() + 1).forEach(num -> headerBuilder.append(VERTICAL_BAR_SYMBOL)
                .append(LOWERCASE_X_SYMBOL)
                .append(num));
        appendRowClosing(headerBuilder);
        System.out.println(headerBuilder);
    }

    public void printRow() {
        StringBuilder rowBuilder = new StringBuilder();
        circuit.getInputs().forEach(input -> rowBuilder.append(VERTICAL_BAR_SYMBOL)
                .append(SPACE_SYMBOL)
                .append(input));
        appendRowClosing(rowBuilder);
        System.out.println(rowBuilder);
    }

    private void appendRowClosing(StringBuilder builder) {
        builder.append(VERTICAL_BAR_SYMBOL)
                .append(NEW_LINE_SYMBOL)
                .append(SPACE_SYMBOL)
                .append(StringUtils.repeat(DASH_SYMBOL, circuit.getInputs().size() * 3 - 1));
    }
}
