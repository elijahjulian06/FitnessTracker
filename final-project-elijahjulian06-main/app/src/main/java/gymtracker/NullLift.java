package gymtracker;

/** NullLift
 *
 * NullLift used to  
 *
 */
public class NullLift extends Lift 
{

    /** NullLift
     * 
     * @param date - date user input for the date that the workout was peformed
     * @param workOutName - name of workout
     * @param totalSetCount - total number of sets
     * @param repCount - total number of repititions 
     * @param rpe - rate of percieved exertion.
     */
    public NullLift()
    {
        super(null, null, 0, 0, 0);
    }

    /** Description
     * 
     * returns nothing for NullLift
     * 
     */
    @Override
    public String Description() 
    {
        return "";
    }

}
