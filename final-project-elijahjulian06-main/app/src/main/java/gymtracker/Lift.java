package gymtracker;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Lift 
{
    private String date;
    private String workOutName;
    private int totalSetCount;
    private int repCount;
    private int rpe;

    private Lift next;

    public HashMap<Integer, Double> sets;


    /** Lift
     * 
     * @param date - date user input for the date that the workout was peformed
     * @param workOutName - name of workout
     * @param totalSetCount - total number of sets
     * @param repCount - total number of repititions 
     * @param rpe - rate of percieved exertion.
     */
    public Lift(String date, String workOutName, int totalSetCount, int repCount, int rpe)
    {
        this.date = date;
        this.workOutName = workOutName;
        this.totalSetCount = totalSetCount;
        this.repCount = repCount;
        this.rpe = rpe;

        sets = new HashMap<>();
    }

    /*
     * puts set and weight into hashmap
     */
    public void addSet(int set, double weight)
    {
        if(sets.containsKey(set) == false)
        {
            sets.put(set, weight);
        }
        else
        {
            throw new UnsupportedOperationException("Set " + set + " has already been recorded");
        }
    }

    /*
     * prints every set for workout 
     */
    public String printSet()
    {
        String ret = "";
        ret += ("Date: " + getDate() + " Workout: " + getWorkOutName() + "\n");
        for(int i = 0; i < getSetCount(); i++)
        {
            ret += ("Set: " + i + " Weight: " + getWeight(i) + "\n");
        }
        return ret;
    }

    public double getAvgTotalWeight()
    {
        double totalWeight = 0;
        for(int i = 0; i < getSetCount(); i++)
        {
            totalWeight += getWeight(i);
        }
        return (totalWeight / getSetCount());
    }

    public ArrayList<Double> getListofWeight()
    {
        ArrayList<Double> wList = new ArrayList<>();
        for(int i = 0; i < getSetCount(); i++)
        {
            wList.add(getWeight(i));
        }
        return wList;
    }

    public void setNextLift(Lift next)
    {   
        this.next = next;
    }

    //getters listed below 
    public Lift getNextLift()
    {
        return next;
    }


    public double getWeight(int set)
    {
        return sets.get(set);
        //insert param into hashmap to get setCount 
    }

    public int getRpe()
    {
        return rpe;
    }

    public int getRepCount()
    {
        return repCount;
    }

    public int getSetCount() 
    {
        return totalSetCount;
    }

    public String getDate()
    {   
        return date;
    }

    public String getWorkOutName()
    {
        return workOutName;
    }

    public abstract String Description();

}
