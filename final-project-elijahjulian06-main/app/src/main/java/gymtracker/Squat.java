package gymtracker;

public class Squat extends Lift 
{


    /** Squat
     * 
     * @param date - date user input for the date that the workout was peformed
     * @param workOutName - name of workout
     * @param totalSetCount - total number of sets
     * @param repCount - total number of repititions 
     * @param rpe - rate of percieved exertion.
     */
    public Squat(String date, String workOutName, int totalSetCount, int repCount, int rpe) {
        super(date, workOutName, totalSetCount, repCount, rpe);
        //TODO Auto-generated constructor stub
    }

    /**
     * 
     * @return copy and pasted from https://www.google.com/search?q=squat+description&rlz=1C5CHFA_enUS911US911&oq=squat+descri&gs_lcrp=EgZjaHJvbWUqBwgAEAAYgAQyBwgAEAAYgAQyBggBEEUYOTIICAIQABgWGB4yCAgDEAAYFhgeMggIBBAAGBYYHjIICAUQABgWGB4yCAgGEAAYFhgeMggIBxAAGBYYHjIICAgQABgWGB4yCAgJEAAYFhgeqAIAsAIA&sourceid=chrome&ie=UTF-8
     */
    public String Description()
    {
        return ": an exercise in which a standing person lowers to a position in which the torso is erect"
        + "\nand the knees are deeply bent and then rises to an upright position."
        + "\nNote: A squat can be done while holding weights,"
        + "\nwith a barbell on the upper back, or without weights.";
    }
    
}
