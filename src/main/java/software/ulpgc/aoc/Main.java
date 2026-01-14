package software.ulpgc.aoc;

import software.ulpgc.aoc.controller.CalibrationController;
import software.ulpgc.aoc.io.TextFileReader;
import software.ulpgc.aoc.view.CalibrationDisplay;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    private static final Path INPUT_PATH = Path.of("src", "main", "resources", "joltage.txt");

    public static void main(String[] args) {
        try {
            // IO
            var rawData = new TextFileReader(INPUT_PATH).readLines();

            // CONTROLLER (para 2 dígitos)
            var controller = CalibrationController.withDigitLength(2);
            long total = controller.processReadings(rawData);

            // VIEW
            new CalibrationDisplay().showResult(total);

        } catch (IOException e) {
            System.err.println("Fallo crítico: " + e.getMessage());
        }
    }
}