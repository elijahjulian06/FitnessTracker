package gymtracker;

/**
 *
 * Class to hold every workout other than benchpress deadlift squat 
 *
 */
public class Accesory extends Lift
{

    /**
     * 
     * @param date - date user input for the date that the workout was peformed
     * @param workOutName - name of workout
     * @param totalSetCount - total number of sets
     * @param repCount - total number of repititions 
     * @param rpe - rate of percieved exertion.
     */
    public Accesory(String date, String workOutName, int totalSetCount, int repCount, int rpe) 
    {
        super(date, workOutName, totalSetCount, repCount, rpe);
    }

    /** Description 
     * 
     * returns a description of the workout.
     * 
     * @return https://www.google.com/search?q=accessory+excerises+description&sca_esv=586679140&rlz=1C5CHFA_enUS911US911&ei=0MxoZfbyCviIptQPwJyWqAo&ved=0ahUKEwj2ms75peyCAxV4hIkEHUCOBaUQ4dUDCBA&uact=5&oq=accessory+excerises+description&gs_lp=Egxnd3Mtd2l6LXNlcnAiH2FjY2Vzc29yeSBleGNlcmlzZXMgZGVzY3JpcHRpb24yBxAhGKABGAoyBxAhGKABGAoyBxAhGKABGApIxxJQlgRYoBFwAXgBkAEBmAHnAqAB8xGqAQcwLjguMi4xuAEDyAEA-AEBwgIKEAAYRxjWBBiwA8ICDRAAGIAEGIoFGLADGEPCAgcQABiABBgNwgIIEAAYCBgeGA3CAgoQABgIGB4YDRgPwgILEAAYgAQYigUYhgPiAwQYACBB4gMFEgExIECIBgGQBgo&sclient=gws-wiz-serp
     */
    public String Description()
    {
        return "Accessory exercises, sometimes referred to as secondary exercises,"
        + "\ngenerally follow on from the so-called 'primary' or 'compound' exercises."
        + "\nThey often allow you to focus on different muscle groups or hit certain muscle groups in different ways";
    }



}
