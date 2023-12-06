package gymtracker;

/** TotalVisitor
 * 
 * implements visitor to help analyze how many lifts there are in total.
 * 
 */
public class TotalVisitor implements Visitor
{
    private static int totalSquat = 0;
    private static int totalAccessory = 0;
    private static int totalBenchPress = 0;
    private static int totalDeadLift = 0;

    /** visit
     * 
     * increments totalDeadLift
     * 
     */
    @Override
    public void visit(DeadLift dl) 
    {   
        totalDeadLift++;
    }

    /** visit
     * 
     * increments totalBenchPress
     * 
     */
    @Override
    public void visit(BenchPress bp)
    {
        totalBenchPress++;
    }

    /** visit
     * 
     * increments totalSquat
     * 
     */
    @Override
    public void visit(Squat s)
    {
        totalSquat++;
    }

    /** visit 
     * 
     * increments totalAccessory
     * 
     */
    @Override
    public void visit(Accesory a)
    {
        totalAccessory++;
    }

    @Override
    public void visit(NullLift nl) 
    {
        //does nothing
    }
    
    /** printTotal
     * 
     * @return - returns the total number of lifts for each lift.
     */
    public String printTotal()
    {
        return "Total number of BenchPress sets: " + totalBenchPress + "\n" +
        "Total number of DeadLift sets: " + totalDeadLift + "\n" +
        "Total number of Squat sets: " + totalSquat + "\n" +
        "Total number of Accesory sets: " + totalAccessory + "\n";
    }
    
    /** getAccessoryTotal
     * 
     * @return totalAccessory
     * 
     */
    public static int getAccessoryTotal()
    {
        return totalAccessory;
    }

    /** getBenchPressTotal
     * 
     * @return totalBenchPressTotal
     */
    public static int getBenchPressTotal()
    {
        return totalBenchPress;
    }

    /** getDeadLiftTotal
     * 
     * @return totalDeadLift
     */
    public static int getDeadLiftTotal()
    {
        return totalDeadLift;
    }

    /** getSquatTotal
     * 
     * @return totalSquat 
     */
    public static int getSquatTotal()
    {
        return totalSquat;
    }   
}



