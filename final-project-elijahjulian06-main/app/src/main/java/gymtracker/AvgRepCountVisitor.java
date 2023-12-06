package gymtracker;

/** AvgRepCountVisitor
 * 
 * implements visitor to help find the average amount of reps.
 * 
 */
public class AvgRepCountVisitor implements Visitor
{

    private static int accessoryTotalRepCount = 0; 
    private static int benchPressTotalRepCount = 0;
    private static int deadLiftTotalRepCount = 0;
    private static int squatTotalRepCount = 0;
    
    /** visit 
     * 
     * increments the total amount of reps from accessory.
     * 
     */
    @Override
    public void visit(Accesory l) 
    {
        accessoryTotalRepCount += l.getRepCount();
    }


    /** visit 
     * 
     * increments the total amount of reps from benchpress.
     * 
     */
    @Override
    public void visit(BenchPress bp) 
    {
        benchPressTotalRepCount += bp.getRepCount();
    }

    /** visit
     * 
     * increments the toal amount of reps from deadlift.
     * 
     */
    @Override
    public void visit(DeadLift dl) 
    {
        deadLiftTotalRepCount += dl.getRepCount();
    }

    /** visit
     * 
     * increments the toal amount of reps from Squat.
     * 
     */
    @Override
    public void visit(Squat s) 
    {
        squatTotalRepCount += s.getRepCount();
    }

    /** visit
     * 
     * increments the toal amount of reps from NullLift.
     * 
     */
    @Override
    public void visit(NullLift nl)
    {
        //do nothing
    }
    
    /** printRepCount
     * 
     * @return returns a string with the average amount of reps for each lift.
     */
    public String printRepCount()
    {
        int accesoryTotal = TotalVisitor.getAccessoryTotal();
        int benchPressTotal = TotalVisitor.getBenchPressTotal();
        int deadLiftTotal = TotalVisitor.getDeadLiftTotal();
        int squatTotal = TotalVisitor.getSquatTotal();

        int avgAccessoryRepCount = accessoryTotalRepCount / accesoryTotal;
        int avgBenchPressRepCount = benchPressTotalRepCount / benchPressTotal;
        int avgDeadLiftRepCount =  deadLiftTotalRepCount / deadLiftTotal;
        int avgSquatRepCount = squatTotalRepCount / squatTotal;

        return "Avg total BenchPress Repetitions: " + avgBenchPressRepCount + "\n" +
        "Avg total DeadLift Repetitions: " + avgDeadLiftRepCount + "\n" +
        "Avg total Squat Repetitions: " + avgSquatRepCount + "\n" +
        "Avg total Accesory Repetitions: " + avgAccessoryRepCount + "\n";


    }
}
