package software.ulpgc.aoc.model;

public record JoltageSequence(String rawData) {

    /*
     * Busca la subsecuencia numérica más alta posible de una longitud dada,
     * respetando el orden original.
     */
    public long extractMaxCalibrationValue(int targetLength) {
        StringBuilder resultBuilder = new StringBuilder();
        int currentSearchIndex = 0;
        int totalLength = rawData.length();

        // Para cada dígito que necesitamos encontrar
        for (int i = 0; i < targetLength; i++) {
            // Calculamos hasta dónde podemos buscar para asegurar que sobran
            // suficientes caracteres para completar los dígitos restantes.
            int remainingNeeded = targetLength - 1 - i;
            int searchLimit = totalLength - remainingNeeded;

            char maxDigitFound = '/'; // Valor ASCII menor que '0'
            int indexFound = currentSearchIndex;

            // Buscamos el dígito más alto en lo que queda
            for (int j = currentSearchIndex; j < searchLimit; j++) {
                char currentChar = rawData.charAt(j);

                if (currentChar > maxDigitFound) {
                    maxDigitFound = currentChar;
                    indexFound = j;

                    if (maxDigitFound == '9') break;
                }
            }

            resultBuilder.append(maxDigitFound);
            // Avanzo el índice para buscar el siguiente dígito DESPUÉS del que acabamos de encontrar
            currentSearchIndex = indexFound + 1;
        }

        return Long.parseLong(resultBuilder.toString());
    }
}