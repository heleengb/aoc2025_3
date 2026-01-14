package software.ulpgc.aoc.command;

import software.ulpgc.aoc.model.JoltageSequence;
import java.util.List;

public class CalculateCalibrationCommand {
    private final List<JoltageSequence> sequences;
    private final int requiredDigits;

    public CalculateCalibrationCommand(List<JoltageSequence> sequences, int requiredDigits) {
        this.sequences = sequences;
        this.requiredDigits = requiredDigits;
    }

    public long execute() {
        return sequences.stream()
                // Mapeamos cada secuencia a su valor máximo según los dígitos pedidos
                .mapToLong(seq -> seq.extractMaxCalibrationValue(requiredDigits))
                .sum();
    }
}