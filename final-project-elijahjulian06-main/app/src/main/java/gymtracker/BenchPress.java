package gymtracker;

public class BenchPress extends Lift
{

    /** BenchPress
     * 
     * @param date - date user input for the date that the workout was peformed
     * @param workOutName - name of workout
     * @param totalSetCount - total number of sets
     * @param repCount - total number of repititions 
     * @param rpe - rate of percieved exertion.
     */
    public BenchPress(String date, String workOutName, int totalSetCount, int repCount, int rpe)
    {
        super(date, workOutName, totalSetCount, repCount, rpe);
        //TODO Auto-generated constructor stub
    }

    /** Description
     * 
     * returns a description of the workout
     * 
     * @return https://www.google.com/search?q=bench+press+description&rlz=1C5CHFA_enUS911US911&oq=bench+press+descriptio&gs_lcrp=EgZjaHJvbWUqBwgAEAAYgAQyBwgAEAAYgAQyBggBEEUYOTIICAIQABgWGB4yCAgDEAAYFhgeMgoIBBAAGA8YFhgeMgoIBRAAGA8YFhgeMgoIBhAAGA8YFhgeMggIBxAAGBYYHjIICAgQABgWGB4yCAgJEAAYFhgeqAIAsAIA&sourceid=chrome&ie=UTF-8
     */
    public String Description()
    {
        return "It involves lying on a bench and pressing weight upward using either a barbell or a pair of dumbbells."
        + "\n During a bench press, you lower the weight down to chest level and then press upwards while extending your arms."
        + "\n This movement is considered one repetition, or rep.";
    }
    
}
