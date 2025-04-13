package io.cdap.wrangler.api.parser;

/**
 * Token class for representing time durations with units (ms, s, etc.)
 */
public class TimeDuration extends Token {
    private final long nanoseconds;

    public TimeDuration(String value) {
        super(TokenType.TIME_DURATION, value);
        this.nanoseconds = parseTimeDuration(value);
    }

    /**
     * Parse a string representation of time duration (e.g., "150ms", "2.1s")
     */
    private long parseTimeDuration(String value) {
        String normalized = value.trim().toLowerCase();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("Empty time duration value");
        }

        // Find the split between number and unit
        int i = 0;
        while (i < normalized.length() && 
               (Character.isDigit(normalized.charAt(i)) || normalized.charAt(i) == '.')) {
            i++;
        }

        if (i == 0 || i == normalized.length()) {
            throw new IllegalArgumentException("Invalid time duration format: " + value);
        }

        double number = Double.parseDouble(normalized.substring(0, i));
        String unit = normalized.substring(i);

        return switch (unit) {
            case "ns" -> (long) number;
            case "us", "µs" -> (long) (number * 1000);
            case "ms" -> (long) (number * 1_000_000);
            case "s" -> (long) (number * 1_000_000_000);
            case "m" -> (long) (number * 60 * 1_000_000_000L);
            case "h" -> (long) (number * 3600 * 1_000_000_000L);
            default -> throw new IllegalArgumentException("Unknown time duration unit: " + unit);
        };
    }

    /**
     * Get the duration in nanoseconds
     */
    public long getNanoseconds() {
        return nanoseconds;
    }

    /**
     * Get the duration in milliseconds
     */
    public double getMilliseconds() {
        return nanoseconds / 1_000_000.0;
    }

    /**
     * Get the duration in seconds
     */
    public double getSeconds() {
        return nanoseconds / 1_000_000_000.0;
    }

    @Override
    public String toString() {
        return String.format("TimeDuration(%s)", getValue());
    }
}
