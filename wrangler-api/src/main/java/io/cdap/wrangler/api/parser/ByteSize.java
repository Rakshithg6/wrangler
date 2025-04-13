package io.cdap.wrangler.api.parser;

/**
 * Token class for representing byte sizes with units (KB, MB, GB, etc.)
 */
public class ByteSize extends Token {
    private final long bytes;

    public ByteSize(String value) {
        super(TokenType.BYTE_SIZE, value);
        this.bytes = parseByteSize(value);
    }

    /**
     * Parse a string representation of byte size (e.g., "10KB", "1.5MB")
     */
    private long parseByteSize(String value) {
        String normalized = value.trim().toUpperCase();
        if (normalized.isEmpty()) {
            throw new IllegalArgumentException("Empty byte size value");
        }

        // Find the split between number and unit
        int i = 0;
        while (i < normalized.length() && 
               (Character.isDigit(normalized.charAt(i)) || normalized.charAt(i) == '.')) {
            i++;
        }

        if (i == 0 || i == normalized.length()) {
            throw new IllegalArgumentException("Invalid byte size format: " + value);
        }

        double number = Double.parseDouble(normalized.substring(0, i));
        String unit = normalized.substring(i);

        return switch (unit) {
            case "B" -> (long) number;
            case "KB" -> (long) (number * 1024);
            case "MB" -> (long) (number * 1024 * 1024);
            case "GB" -> (long) (number * 1024 * 1024 * 1024);
            case "TB" -> (long) (number * 1024L * 1024L * 1024L * 1024L);
            default -> throw new IllegalArgumentException("Unknown byte size unit: " + unit);
        };
    }

    /**
     * Get the size in bytes
     */
    public long getBytes() {
        return bytes;
    }

    /**
     * Get the size in megabytes
     */
    public double getMegabytes() {
        return bytes / (1024.0 * 1024.0);
    }

    /**
     * Get the size in gigabytes
     */
    public double getGigabytes() {
        return bytes / (1024.0 * 1024.0 * 1024.0);
    }

    @Override
    public String toString() {
        return String.format("ByteSize(%s)", getValue());
    }
}
