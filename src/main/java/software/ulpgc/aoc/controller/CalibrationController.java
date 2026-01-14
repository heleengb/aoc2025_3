package software.ulpgc.aoc.controller;

import software.ulpgc.aoc.command.CalculateCalibrationCommand;
import software.ulpgc.aoc.model.JoltageSequence;

import java.util.List;

public class CalibrationController {
    private final int sequenceLength;

    private CalibrationController(int sequenceLength) {
        this.sequenceLength = sequenceLength;
    }

    // Factory Method
    public static CalibrationController withDigitLength(int length) {
        return new CalibrationController(length);
    }

    public long processReadings(List<String> rawLines) {
        // Convertimos strings a secuencias (clase JoltageSequence)
        List<JoltageSequence> sequences = rawLines.stream()
                .map(JoltageSequence::new)
                .toList();

        // Ejecutamos el comando
        return new CalculateCalibrationCommand(sequences, sequenceLength).execute();
    }
}