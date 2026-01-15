package axl.itmo;

import org.jetbrains.annotations.NotNull;

public enum Weather {
    SUNNY("Солнечная"),
    CLOUDY("Облачная"),
    RAINY("Дождливая");

    // Markov Chain Transition Matrix
    // Rows: current weather state
    // Columns: probabilities for next weather state (SUNNY, CLOUDY, RAINY)
    // Each row must sum to 1.0 (100%)
    private static final double[][] TRANSITION_MATRIX = {
            {0.6, 0.3, 0.1},   // After SUNNY: 60% stay sunny, 30% become cloudy, 10% become rainy
            {0.3, 0.4, 0.3},   // After CLOUDY: 30% become sunny, 40% stay cloudy, 30% become rainy
            {0.2, 0.3, 0.5}    // After RAINY: 20% become sunny, 30% become cloudy, 50% stay rainy
    };

    private final @NotNull String name;

    Weather(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getName() {
        return name;
    }

    @Override
    public @NotNull String toString() {
        return getName();
    }

    public @NotNull Weather getNextWeather() {
        double randomValue = Math.random();
        double cumulativeProbability = 0.0;

        int currentStateIndex = this.ordinal();

        double[] probabilities = TRANSITION_MATRIX[currentStateIndex];

        for (int nextStateIndex = 0; nextStateIndex < values().length; nextStateIndex++) {
            cumulativeProbability += probabilities[nextStateIndex];

            if (randomValue <= cumulativeProbability) {
                return values()[nextStateIndex];
            }
        }

        // Fallback (should never reach here if matrix is properly defined)
        return Weather.SUNNY;
    }
}