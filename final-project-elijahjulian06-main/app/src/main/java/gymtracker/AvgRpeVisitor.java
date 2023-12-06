package gymtracker;

/** AvgRpeVisitor
 * 
 * implements visitor to find how the average rate of exertion.
 * 
 */
public class AvgRpeVisitor implements Visitor
{
    private static int accesoryRpeTotal = 0;
    private static int squatRpeTotal = 0;
    private static int deadLiftRpeTotal = 0;
    private static int benchPressRpeTotal = 0;
    
    /** visit
     * 
     * increments total rpe for accessory.
     * 
     */
    @Override
    public void visit(Accesory l) 
    {
        accesoryRpeTotal += l.getRpe();
    }

    /**
     * 
     *  increments total rpe for benchpress.
     * 
     */
    @Override
    public void visit(BenchPress bp) 
    {
        benchPressRpeTotal += bp.getRpe();
    }

    /** visit
     * 
     * increments total rpe for dl.
     * 
     */
    @Override
    public void visit(DeadLift dl) 
    {
        deadLiftRpeTotal += dl.getRpe();
    }

    /** visit
     * 
     * increments total rpe for squat.
     * 
     */
    @Override
    public void visit(Squat s) 
    {
        squatRpeTotal += s.getRpe();
    }

    /** visit
     * 
     * does nothing for null lift.
     * 
     */
    @Override
    public void visit(NullLift nl) 
    {
        //do nothing
    }
    
    /** printAvgRpe
     * 
     * @return prints the average rate of percieved exertion.
     * 
     */
    public String printAvgRpe()
    {
        int accessoryTotal = TotalVisitor.getAccessoryTotal();
        int benchPressTotal = TotalVisitor.getBenchPressTotal();
        int deadLiftTotal = TotalVisitor.getDeadLiftTotal();
        int squatTotal = TotalVisitor.getSquatTotal();

        int avgAccessoryRpe = accesoryRpeTotal / accessoryTotal;
        int avgBenchPressRpe = benchPressRpeTotal / benchPressTotal;
        int avgDeadLiftRpe =  deadLiftRpeTotal / deadLiftTotal;
        int avgSquatRpe = squatRpeTotal / squatTotal;

        return "Avg total BenchPress rate of perceived exertion : " + avgBenchPressRpe + "\n" +
        "Avg total DeadLift rate of perceived exertion  " + avgDeadLiftRpe + "\n" +
        "Avg total Squat rate of perceived exertion : " + avgSquatRpe + "\n" +
        "Avg total Accesory rate of perceived exertion : " + avgAccessoryRpe + "\n";
    }
}
