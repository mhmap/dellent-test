package com.example.DellentApplication;
import com.example.DellentApplication.service.LabSeqService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;

public class LabSeqServiceTest {
    private final LabSeqService labSeqService = new LabSeqService();

    @Test
    void testLabSeqLength() {
        BigInteger[] seq = labSeqService.labseq(10);
        Assertions.assertEquals(10, seq.length);
    }

    @Test
    void testLabSeqValues() {
        BigInteger[] seq = labSeqService.labseq(10);
        Assertions.assertEquals(BigInteger.valueOf(0), seq[0]);
        Assertions.assertEquals(BigInteger.valueOf(1), seq[1]);
        Assertions.assertEquals(BigInteger.valueOf(0), seq[2]);
        Assertions.assertEquals(BigInteger.valueOf(1), seq[3]);
        Assertions.assertEquals(BigInteger.valueOf(1), seq[4]);
        Assertions.assertEquals(BigInteger.valueOf(1), seq[5]);
        Assertions.assertEquals(BigInteger.valueOf(1), seq[6]);
        Assertions.assertEquals(BigInteger.valueOf(2), seq[7]);
        Assertions.assertEquals(BigInteger.valueOf(2), seq[8]);
        Assertions.assertEquals(BigInteger.valueOf(2), seq[9]);
    }

    @Test
    void testLabSeqPerformance() {
        long start = System.currentTimeMillis();
        labSeqService.labseq(1000);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        Assertions.assertTrue(timeElapsed < 10000, "Elapsed time too long: " + timeElapsed + "ms");
    }
}
