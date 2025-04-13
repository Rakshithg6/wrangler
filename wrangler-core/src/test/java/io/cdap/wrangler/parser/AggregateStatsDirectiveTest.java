package io.cdap.wrangler.parser;

import io.cdap.wrangler.api.Record;
import io.cdap.wrangler.api.ExecutorContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class AggregateStatsDirectiveTest {
    
    @Mock
    private ExecutorContext context;
    
    private AggregateStatsDirective directive;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        directive = new AggregateStatsDirective();
    }
    
    @Test
    public void testAggregation() throws Exception {
        // Create test data
        List<Record> records = new ArrayList<>();
        
        Record r1 = new Record();
        r1.setValue("data_size", "1.5MB");
        r1.setValue("response_time", "100ms");
        records.add(r1);
        
        Record r2 = new Record();
        r2.setValue("data_size", "500KB");
        r2.setValue("response_time", "50ms");
        records.add(r2);
        
        // Initialize directive
        TokenGroup group = new TokenGroup();
        group.add("byteSizeColumn", new Token(TokenType.COLUMN_NAME, "data_size"));
        group.add("timeDurationColumn", new Token(TokenType.COLUMN_NAME, "response_time"));
        group.add("targetSizeColumn", new Token(TokenType.COLUMN_NAME, "total_size_mb"));
        group.add("targetTimeColumn", new Token(TokenType.COLUMN_NAME, "total_time_sec"));
        
        directive.initialize(group);
        
        // Execute directive
        List<Record> results = directive.execute(records, context);
        
        // Verify results
        Assert.assertEquals(1, results.size());
        Record result = results.get(0);
        
        // Expected: 1.5MB + 500KB = ~1.988MB
        Assert.assertEquals(1.988, result.getValue("total_size_mb"), 0.001);
        
        // Expected: 150ms = 0.15 seconds
        Assert.assertEquals(0.15, result.getValue("total_time_sec"), 0.001);
    }
    
    @Test
    public void testEmptyRecords() throws Exception {
        TokenGroup group = new TokenGroup();
        group.add("byteSizeColumn", new Token(TokenType.COLUMN_NAME, "data_size"));
        group.add("timeDurationColumn", new Token(TokenType.COLUMN_NAME, "response_time"));
        group.add("targetSizeColumn", new Token(TokenType.COLUMN_NAME, "total_size_mb"));
        group.add("targetTimeColumn", new Token(TokenType.COLUMN_NAME, "total_time_sec"));
        
        directive.initialize(group);
        
        List<Record> results = directive.execute(new ArrayList<>(), context);
        
        Assert.assertEquals(1, results.size());
        Record result = results.get(0);
        Assert.assertEquals(0.0, result.getValue("total_size_mb"));
        Assert.assertEquals(0.0, result.getValue("total_time_sec"));
    }
}
