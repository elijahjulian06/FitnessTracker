package gymtracker;

/** AvgTotalVisitor
 * 
 */
public class AvgTotalVisitor implements Visitor
{

    public static double totalAccesoryWeight = 0;
    public static double totalDeadLiftWeight = 0;
    public static double totalBenchPressWeight = 0;
    public static double totalSquatWeight = 0;

    /** visit
     * 
     * increments the total weight for accessory.
     * 
     */
    @Override
    public void visit(Accesory l) 
    {
        totalAccesoryWeight += l.getAvgTotalWeight();
    }

    /** visit
     * 
     * increments the total weight for deadlift.
     * 
     */
    @Override
    public void visit(DeadLift dl) 
    {
        totalDeadLiftWeight += dl.getAvgTotalWeight();
    }

    /** visit
     * 
     * increments the total weight for benchpress.
     * 
     */
    @Override
    public void visit(BenchPress bp) 
    {
        totalBenchPressWeight += bp.getAvgTotalWeight();
    }

    /** visit
     * 
     * increments the total weight for squat.
     * 
     */
    @Override
    public void visit(Squat s)
    {
        totalSquatWeight += s.getAvgTotalWeight();
    }

    /** visit
     * 
     * does nothing
     * 
     */
    @Override
    public void visit(NullLift nl)
    {
        //do nothing
    }

    /** printAvgWeight
     * 
     * @return prints the average weight for each lift.
     * 
     */
    public String printAvgWeight()
    {
        int accesoryTotal = TotalVisitor.getAccessoryTotal();
        int benchPressTotal = TotalVisitor.getBenchPressTotal();
        int deadLiftTotal = TotalVisitor.getDeadLiftTotal();
        int squatTotal = TotalVisitor.getSquatTotal();

        double avgLiftWeight = totalAccesoryWeight / accesoryTotal;
        double avgBenchPressWeight = totalBenchPressWeight / benchPressTotal;
        double avgDeadLiftWeight =  totalDeadLiftWeight / deadLiftTotal;
        double avgSquatWeight = totalSquatWeight / squatTotal;

        return "Avg total BenchpPress weight: " + Math.round(avgBenchPressWeight) + "lbs\n" +
        "Avg total DeadLift weight: " + Math.round(avgDeadLiftWeight) + "lbs\n" +
        "Avg total Squat weight: " + Math.round(avgSquatWeight) + "lbs\n" +
        "Avg total Accesory weight: " + Math.round(avgLiftWeight) + "lbs\n";
    }
    
}
