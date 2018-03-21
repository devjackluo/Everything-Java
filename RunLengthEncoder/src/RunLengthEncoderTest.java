import org.junit.Test;

import static org.junit.Assert.*;

public class RunLengthEncoderTest {


    @Test
    public void test1(){
        final RunLengthEncoder runLengthEncoder = new RunLengthEncoder();
        final String testData = "AAAAAAAAAAABBB";
        final String encodedData = runLengthEncoder.encode(testData);
        final String decodedData = runLengthEncoder.decode(encodedData);

        assertEquals(testData.length(), 14);
        assertEquals(encodedData.length(), 5);
        assertEquals(testData, decodedData);
        assertEquals(testData.length(), decodedData.length());

        printStats(testData, encodedData);
    }

    private static void printStats(final String testData, final String encodedData){
        System.out.println("testData = " + testData);
        System.out.println("encodedData = " + encodedData);

        final float savings = (1.0f - ((float)encodedData.length()/testData.length())) * 100;
        System.out.println("savings = "+savings+ "%");
    }


}