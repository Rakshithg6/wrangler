# Wrangler Enhancement: Byte Size and Time Duration Units Parsers

This project enhances the CDAP Wrangler library by adding native support for parsing and utilizing byte size and time duration units within recipes.

## New Features

- Support for byte size units (KB, MB, GB, etc.)
- Support for time duration units (ms, s, etc.)
- New aggregate-stats directive for data size and time calculations
- Comprehensive test coverage for new features

## Implementation Details

### New Token Types
- BYTE_SIZE: Parses values like "10KB", "1.5MB", "2GB"
- TIME_DURATION: Parses values like "150ms", "2.1s"

### New Classes
- ByteSize.java: Handles byte size parsing and conversions
- TimeDuration.java: Handles time duration parsing and conversions

### Modified Components
- Enhanced grammar rules in Directives.g4
- Updated parser logic in wrangler-core
- New aggregate-stats directive implementation

## Usage

Example recipe using the new aggregate-stats directive:
```
aggregate-stats :data_transfer_size :response_time total_size_mb total_time_sec
```

## Testing
Comprehensive test suite includes:
- Unit tests for ByteSize and TimeDuration classes
- Parser tests for new token types
- Integration tests for aggregate-stats directive
- Edge case handling tests
