package software.ulpgc.aoc.view;

public class CalibrationDisplay implements SolutionPrinter {
    @Override
    public void showResult(long result) {
        System.out.println("Suma total de calibración máxima: " + result);
    }
}