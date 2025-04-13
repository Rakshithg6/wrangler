package io.cdap.wrangler.parser;

import io.cdap.wrangler.api.parser.ByteSize;
import io.cdap.wrangler.api.parser.TimeDuration;
import io.cdap.wrangler.api.parser.UsageDefinition;
import io.cdap.wrangler.api.parser.TokenGroup;
import io.cdap.wrangler.api.parser.DirectiveExecutionException;
import io.cdap.wrangler.api.parser.Value;
import io.cdap.wrangler.api.Record;
import io.cdap.wrangler.api.ExecutorContext;

import java.util.List;

/**
 * A directive for aggregating byte sizes and time durations.
 */
public class AggregateStatsDirective implements Directive {
    private String byteSizeColumn;
    private String timeDurationColumn;
    private String targetSizeColumn;
    private String targetTimeColumn;
    private long totalBytes;
    private long totalNanoseconds;
    private int rowCount;

    @Override
    public UsageDefinition define() {
        UsageDefinition.Builder builder = UsageDefinition.builder("aggregate-stats");
        builder.define("byteSizeColumn", TokenType.COLUMN_NAME);
        builder.define("timeDurationColumn", TokenType.COLUMN_NAME);
        builder.define("targetSizeColumn", TokenType.COLUMN_NAME);
        builder.define("targetTimeColumn", TokenType.COLUMN_NAME);
        return builder.build();
    }

    @Override
    public void initialize(TokenGroup group) throws DirectiveExecutionException {
        this.byteSizeColumn = group.get("byteSizeColumn").value();
        this.timeDurationColumn = group.get("timeDurationColumn").value();
        this.targetSizeColumn = group.get("targetSizeColumn").value();
        this.targetTimeColumn = group.get("targetTimeColumn").value();
        this.totalBytes = 0;
        this.totalNanoseconds = 0;
        this.rowCount = 0;
    }

    @Override
    public List<Record> execute(List<Record> records, ExecutorContext context) 
        throws DirectiveExecutionException {
        
        for (Record record : records) {
            Object sizeObj = record.getValue(byteSizeColumn);
            Object timeObj = record.getValue(timeDurationColumn);

            if (sizeObj != null) {
                ByteSize byteSize = new ByteSize(sizeObj.toString());
                totalBytes += byteSize.getBytes();
            }

            if (timeObj != null) {
                TimeDuration timeDuration = new TimeDuration(timeObj.toString());
                totalNanoseconds += timeDuration.getNanoseconds();
            }

            rowCount++;
        }

        // Create a new record with the aggregated values
        Record result = new Record();
        result.setValue(targetSizeColumn, totalBytes / (1024.0 * 1024.0)); // Convert to MB
        result.setValue(targetTimeColumn, totalNanoseconds / 1_000_000_000.0); // Convert to seconds

        return List.of(result);
    }

    @Override
    public void destroy() {
        // Reset aggregation state
        totalBytes = 0;
        totalNanoseconds = 0;
        rowCount = 0;
    }
}
