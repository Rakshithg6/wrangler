package io.cdap.wrangler.parser;

import io.cdap.wrangler.api.parser.ByteSize;
import io.cdap.wrangler.api.parser.TimeDuration;
import org.junit.Assert;
import org.junit.Test;

public class ByteSizeTimeDurationTest {
    
    @Test
    public void testByteSizeParsing() {
        // Test basic units
        Assert.assertEquals(1024, new ByteSize("1KB").getBytes());
        Assert.assertEquals(1024 * 1024, new ByteSize("1MB").getBytes());
        Assert.assertEquals(1024 * 1024 * 1024, new ByteSize("1GB").getBytes());
        
        // Test decimal values
        Assert.assertEquals(1536, new ByteSize("1.5KB").getBytes());
        Assert.assertEquals(1572864, new ByteSize("1.5MB").getBytes());
        
        // Test different formats
        Assert.assertEquals(1024, new ByteSize("1kb").getBytes());
        Assert.assertEquals(1024, new ByteSize("1 KB").getBytes());
        
        // Test byte to MB conversion
        ByteSize size = new ByteSize("1.5MB");
        Assert.assertEquals(1.5, size.getMegabytes(), 0.001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidByteSize() {
        new ByteSize("invalid");
    }
    
    @Test
    public void testTimeDurationParsing() {
        // Test basic units
        Assert.assertEquals(1_000_000, new TimeDuration("1ms").getNanoseconds());
        Assert.assertEquals(1_000_000_000, new TimeDuration("1s").getNanoseconds());
        Assert.assertEquals(60_000_000_000L, new TimeDuration("1m").getNanoseconds());
        
        // Test decimal values
        Assert.assertEquals(1_500_000, new TimeDuration("1.5ms").getNanoseconds());
        Assert.assertEquals(1_500_000_000, new TimeDuration("1.5s").getNanoseconds());
        
        // Test different formats
        Assert.assertEquals(1_000_000, new TimeDuration("1MS").getNanoseconds());
        Assert.assertEquals(1_000_000, new TimeDuration("1 ms").getNanoseconds());
        
        // Test conversions
        TimeDuration duration = new TimeDuration("1.5s");
        Assert.assertEquals(1.5, duration.getSeconds(), 0.001);
        Assert.assertEquals(1500.0, duration.getMilliseconds(), 0.001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTimeDuration() {
        new TimeDuration("invalid");
    }
}
