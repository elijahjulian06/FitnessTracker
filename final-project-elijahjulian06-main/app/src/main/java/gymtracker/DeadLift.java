package gymtracker;

public class DeadLift extends Lift 
{

    public DeadLift(String date, String workOutName, int totalSetCount, int repCount, int rpe) 
    {
        super(date, workOutName, totalSetCount, repCount, rpe);
    }



    /** Description
     * 
     * prints a description of the workout
     * 
     * @return copy and pasted from https://www.physio-pedia.com/Deadlift_Exercise#:~:text=Introduction-,Deadlift,%2C%20thighs%2C%20and%20back%20musculature.
     */
    public String Description()
    {
        return "Deadlift. The deadlift exercise is a relatively simple exercise to perform,"
        + "\n a weight is lifted from a resting position on the floor to an upright position."
        + "\n The deadlift exercise utilizes multiple muscle groups to perform but has been used to strength the hips, thighs, and back musculature.";
    }
    
}
