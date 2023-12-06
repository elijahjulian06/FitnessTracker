package gymtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** VisitorTest
 * 
 * Test for the visitor pattern.
 * 
 */
public class VisitorTest 
{
    
    /** 
     * expected values.
     */
    private final String PRINTAVGWEIGHT = "Avg total BenchpPress weight: 50lbs\n" + 
                                          "Avg total DeadLift weight: 75lbs\n" + 
                                          "Avg total Squat weight: 25lbs\n" + 
                                          "Avg total Accesory weight: 100lbs\n";

    private final String PRINTAVGRPE = "Avg total BenchPress rate of perceived exertion : 2\n" + 
                                            "Avg total DeadLift rate of perceived exertion  1\n" + 
                                            "Avg total Squat rate of perceived exertion : 2\n" + 
                                            "Avg total Accesory rate of perceived exertion : 1\n";
    
    private final String PRINTAVGREPCOUNT = "Avg total BenchPress Repetitions: 10\n" + 
                                            "Avg total DeadLift Repetitions: 8\n" + 
                                            "Avg total Squat Repetitions: 9\n" + 
                                            "Avg total Accesory Repetitions: 7\n";
    
    private final String PRINTTOTAL = "Total number of BenchPress sets: 3\n" 
                                     + "Total number of DeadLift sets: 3\n" 
                                     + "Total number of Squat sets: 3\n" 
                                     + "Total number of Accesory sets: 3\n";

    private BenchPress testBenchPress;
    private Squat testSquat;
    private DeadLift testDeadLift;
    private Accesory testAccesory;


    private TotalVisitor testTotalVisitor;
    private AvgTotalVisitor testAvgTotalVisitor;
    private AvgRpeVisitor testAvgRPEVisitor;
    private AvgRepCountVisitor testAvgRepCountVisitor;


    /** beforeEach
     * 
     * mocks and initalizes every object needed for testing.
     * 
     */
    @BeforeEach
    public void BeforeEach()
    {
        testBenchPress = mock(BenchPress.class);
        testSquat = mock(Squat.class);
        testDeadLift = mock(DeadLift.class);
        testAccesory = mock(Accesory.class);
        
        testTotalVisitor = new TotalVisitor();
        testAvgTotalVisitor = new AvgTotalVisitor();
        testAvgRPEVisitor = new AvgRpeVisitor();
        testAvgRepCountVisitor = new AvgRepCountVisitor();
    }


    /** testPrintAvgWeight()
     * 
     * test if average weight visitor is correct.
     *
     */
    @Test 
    public void testPrintAvgWeight()
    {  
        testTotalVisitor = new TotalVisitor();

        testTotalVisitor.visit(testBenchPress);
        testTotalVisitor.visit(testSquat);
        testTotalVisitor.visit(testDeadLift);
        testTotalVisitor.visit(testAccesory);
        

        when(testBenchPress.getAvgTotalWeight()).thenReturn(200.0);
        when(testSquat.getAvgTotalWeight()).thenReturn(100.0);
        when(testDeadLift.getAvgTotalWeight()).thenReturn(300.0);
        when(testAccesory.getAvgTotalWeight()).thenReturn(400.0);

        testAvgTotalVisitor.visit(testBenchPress);
        testAvgTotalVisitor.visit(testSquat);
        testAvgTotalVisitor.visit(testDeadLift);
        testAvgTotalVisitor.visit(testAccesory);

        assertEquals(PRINTAVGWEIGHT, testAvgTotalVisitor.printAvgWeight());
    
    }

    /** testPrintAvgRpe
     * 
     * test if average rpe visitor is correct.
     * 
     */
    @Test
    public void testPrintAvgRpe()
    {   
        testTotalVisitor = new TotalVisitor();

        testTotalVisitor.visit(testBenchPress);
        testTotalVisitor.visit(testSquat);
        testTotalVisitor.visit(testDeadLift);
        testTotalVisitor.visit(testAccesory);
        
        when(testBenchPress.getRpe()).thenReturn(5);
        when(testSquat.getRpe()).thenReturn(4);
        when(testDeadLift.getRpe()).thenReturn(3);
        when(testAccesory.getRpe()).thenReturn(2);

        testAvgRPEVisitor.visit(testBenchPress);
        testAvgRPEVisitor.visit(testSquat);
        testAvgRPEVisitor.visit(testDeadLift);
        testAvgRPEVisitor.visit(testAccesory);

        assertEquals(PRINTAVGRPE, testAvgRPEVisitor.printAvgRpe());
    }

    /** testPrintAverageRepCount
     *  
     * test if average rep count is correct.
     * 
     */
    @Test
    public void testPrintAverageRepCount()
    {
        testTotalVisitor = new TotalVisitor();

        testTotalVisitor.visit(testBenchPress);
        testTotalVisitor.visit(testSquat);
        testTotalVisitor.visit(testDeadLift);
        testTotalVisitor.visit(testAccesory);
        
        when(testBenchPress.getRepCount()).thenReturn(10);
        when(testSquat.getRepCount()).thenReturn(9);
        when(testDeadLift.getRepCount()).thenReturn(8);
        when(testAccesory.getRepCount()).thenReturn(7);

        testAvgRepCountVisitor.visit(testBenchPress);
        testAvgRepCountVisitor.visit(testSquat);
        testAvgRepCountVisitor.visit(testDeadLift);
        testAvgRepCountVisitor.visit(testAccesory);

        assertEquals(PRINTAVGREPCOUNT, testAvgRepCountVisitor.printRepCount());

    }


    /** printTotal
     * 
     * test that the total number of visits is correct. 
     * is four because it is a static class.
     */
    @Test 
    public void testPrintTotal()
    {
        testTotalVisitor = new TotalVisitor();
        testTotalVisitor.visit(testBenchPress);
        testTotalVisitor.visit(testDeadLift);
        testTotalVisitor.visit(testSquat);
        testTotalVisitor.visit(testAccesory);
        assertEquals(PRINTTOTAL, testTotalVisitor.printTotal());

    }

}


