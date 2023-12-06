package gymtracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** LiftTest
 * 
 * test every lift class.
 * 
 */
public class LiftTest 
{
    private Lift testLift;
    private BenchPress testBenchPress;
    private Squat testSquat;
    private DeadLift testDeadLift;
    private Accesory testAccesory;

    private final String BENCHPRESSDESCIPTION = "It involves lying on a bench and pressing weight upward using either a barbell or a pair of dumbbells. During a bench press, you lower the weight down to chest level and then press upwards while extending your arms. This movement is considered one repetition, or rep.";
    private final String SQUATDESCRIPTION = ": an exercise in which a standing person lowers to a position in which the torso is erect and the knees are deeply bent and then rises to an upright position. Note: A squat can be done while holding weights, with a barbell on the upper back, or without weights.";
    private final String DEADLIFTDESCRIPTION = "Deadlift. The deadlift exercise is a relatively simple exercise to perform, a weight is lifted from a resting position on the floor to an upright position. The deadlift exercise utilizes multiple muscle groups to perform but has been used to strength the hips, thighs, and back musculature.";
    private final String ACCESORYDESCRIPTION = "Accessory exercises, sometimes referred to as secondary exercises, generally follow on from the so-called 'primary' or 'compound' exercises. They often allow you to focus on different muscle groups or hit certain muscle groups in different ways";
    private final String PRINTSET = "Date: 12/4/23 Workout: BenchPress" + "\n" 
                                    + "Set: 0 Weight: 100.0" + "\n"
                                    + "Set: 1 Weight: 150.0" + "\n" 
                                    + "Set: 2 Weight: 200.0" + "\n";
    @BeforeEach
    public void berforeEach()
    {
        testLift = mock(Lift.class);
        testBenchPress = mock(BenchPress.class);
        testSquat = mock(Squat.class);
        testDeadLift = mock(DeadLift.class);
        testAccesory = mock(Accesory.class);
        
    }

    /** testDescription
     * 
     * test if description is being printed off right.
     * 
     */
    @Test 
    public void testDescription()
    {   
        when(testBenchPress.Description()).thenReturn(BENCHPRESSDESCIPTION);
        when(testSquat.Description()).thenReturn(SQUATDESCRIPTION);
        when(testDeadLift.Description()).thenReturn(DEADLIFTDESCRIPTION);
        when(testAccesory.Description()).thenReturn(ACCESORYDESCRIPTION);

        assertEquals(BENCHPRESSDESCIPTION, testBenchPress.Description());
        assertEquals(SQUATDESCRIPTION, testSquat.Description());
        assertEquals(DEADLIFTDESCRIPTION, testDeadLift.Description());
        assertEquals(ACCESORYDESCRIPTION, testAccesory.Description());
    }

    /** testPrintSet
     * 
     * test if values are being hashed in correctly.
     * And test if they are being printed correctly.
     *
     */
    @Test
    public void testPrintSet()
    {
        testBenchPress = new BenchPress("12/4/23", "BenchPress", 3,0, 0);
        
        testBenchPress.addSet(0, 100.00);
        testBenchPress.addSet(1, 150.00);
        testBenchPress.addSet(2, 200.00);

        assertEquals(PRINTSET, testBenchPress.printSet());
        

    }

    /** testGetAvgTotalWeight
     * 
     * test if the average weight for a workout is being calculated right.
     * 
     */
    @Test
    public void testGetAvgTotalWeight() {
        
        testBenchPress = new BenchPress(null, null, 3,0, 0);

        testBenchPress.addSet(0, 100.00);
        testBenchPress.addSet(1, 150.00);
        testBenchPress.addSet(2, 200.00);

        double avgTotalWeight = testBenchPress.getAvgTotalWeight();

        assertEquals(150.00, avgTotalWeight, 0.001);
       
    }

    
}
