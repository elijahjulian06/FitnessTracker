package gymtracker;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVWriter;

/** CsvReaderWriter
 * 
 * reads csv file and turns it into a linked list of Lifts.
 * 
 */
public class CsvReaderWriter
{
    //iterator container
    private FowardContainer fContainer;
    private ForwardIterator fit;

    //visitors
    private TotalVisitor totalVisitor;

    private AvgRepCountVisitor avgRepCountVisitor;
    private AvgRpeVisitor avgRpeVisitor;
    private AvgTotalVisitor avgTotalVisitor;

    private ArrayList<BenchPress> bpList;
    private ArrayList<DeadLift> dlList;
    private ArrayList<Squat> sList;
    private ArrayList<Accesory> aList;

    private String error = "";
    private boolean checkError = false;
    private Lift head;

    /**
     * puts all data into a array list 
     * 
     * @param filename - path of file.
     * @return - returns a string array list parsed from file.
     * @throws FileNotFoundException
     * 
     * I refrenced code from these websites.
     * https://www.baeldung.com/java-csv-file-array
     * https://gist.github.com/timothyshort/e17dda748b4b3ab83cb135589037f786
     */
    public ArrayList<String> readCSV(String filename) throws FileNotFoundException
    {
        ArrayList<String> raw = new ArrayList<>();
        Scanner sc = new Scanner(new File(filename));  
        sc.useDelimiter(","); 
        
        sc.nextLine();
        while (sc.hasNextLine()) 
        {   
            String line = sc.nextLine();
            String[] values = line.split(",");

            for (String value : values) 
            {
                raw.add(value);
            }  
        }
        
        sc.close(); 
        return raw;
    }
    /**
     * builds a Lift type using data from ArrayList
     * 
     * @param raw - ArrayList obtained from csv data
     * 
     */
    public Lift buildType(ArrayList<String> raw)
    {
        String date = raw.get(0);
        String name = raw.get(1);
        Integer setCount = Integer.parseInt(raw.get(2));
        Integer repCount = Integer.parseInt(raw.get(3));
        Integer rpe = Integer.parseInt(raw.get(4));

        Lift lift = null;

        if(name.toLowerCase().equals("benchpress"))
        {
            lift = new BenchPress(date, name, setCount, repCount, rpe);
        }
        else if(name.toLowerCase().equals("deadlift"))
        {
            lift = new DeadLift(date, name, setCount, repCount, rpe);
        }
        else if(name.toLowerCase().equals("squat"))
        {
            lift = new Squat(date, name, setCount, repCount, rpe);
        }
        else
        {
            lift = new Accesory(date, name, setCount, repCount, rpe);
        }


        for(int i = 0; i < setCount; i++)
        {
            lift.addSet(i, Double.parseDouble(raw.get(i + 5)));
        }
    
        //remove elements added to lift 
        for(int i = 0; i < 5 + setCount; i++)
        { 
            raw.remove(0);
        }

        return lift;
        
    }

    /** buildList
     * 
     * builds a linked list 
     * 
     * @param raw - array list of raw workouts from csv 
     */
    public void  buildList(ArrayList<String> raw)
    {
   
        fContainer = new FowardContainer();

        head = buildType(raw);
        
        fContainer.addNextLift(head);

        if(head.getWorkOutName().toLowerCase().equals("benchpress"))
        {
            LiftAnalysis(null, (BenchPress) head, null, null);
        }
        else if(head.getWorkOutName().toLowerCase().equals("deadlift"))
        {
            LiftAnalysis(null, null , (DeadLift) head, null);
        }
        else if(head.getWorkOutName().toLowerCase().equals("squat"))
        {
            LiftAnalysis(null, null , null, (Squat) head);
        }
        else
        {
            LiftAnalysis((Accesory) head, null , null, null);
        }


        while(raw.size() != 0)
        {
            if(raw.get(1).toLowerCase().equals("benchpress"))
            {
                Lift benchPress = buildType(raw);
                fContainer.addNextLift(benchPress);
                LiftAnalysis(null, (BenchPress) benchPress, null, null);
            }
            else if(raw.get(1).toLowerCase().equals("deadlift"))
            {
                Lift deadLift = buildType(raw);
                fContainer.addNextLift(deadLift);
                LiftAnalysis(null, null, (DeadLift) deadLift, null);
              
            }
            else if(raw.get(1).toLowerCase().equals("squat"))
            {
                Lift squat = buildType(raw);
                fContainer.addNextLift(squat);
                LiftAnalysis(null, null, null, (Squat) squat);
             
            }
            else
            {
                Lift accessory = buildType(raw);
                fContainer.addNextLift(accessory);
                LiftAnalysis((Accesory) accessory, null, null, null);
            }

        }

        fit = (ForwardIterator) fContainer.getIterator(head);

    }

    /** organizeLifts
     * 
     * puts all lifts into four different array list for printing and writing method.
     *  
     * @param filename file path its just passed into csvwriter.
     * @param fit foward iterator
     * @throws IOException
     */
    public void organizeLifts(String filename, ForwardIterator fit) throws IOException
    {
        fit.reset();
        bpList = new ArrayList<>();
        while(fit.hasNext())
        {
            if(fit.getCurrent() instanceof BenchPress)
            {
                bpList.add((BenchPress) fit.getCurrent());
            }
            fit.next();
        }
        fit.next();
        if(fit.getCurrent() instanceof BenchPress)
        {
            bpList.add((BenchPress) fit.getCurrent());
        }
        fit.next();
        
        fit.reset();
        dlList = new ArrayList<>();
        while(fit.hasNext())
        {
            if(fit.getCurrent() instanceof DeadLift)
            {
                dlList.add((DeadLift) fit.getCurrent());
            }
            fit.next();
        }
        if(fit.getCurrent() instanceof DeadLift)
        {
            dlList.add((DeadLift) fit.getCurrent());
        }
        fit.next();


        fit.reset();
        sList = new ArrayList<>();
        while(fit.hasNext())
        {
            if(fit.getCurrent() instanceof Squat)
            {
                sList.add((Squat) fit.getCurrent());
            }
            fit.next();
        }
        fit.next();
        if(fit.getCurrent() instanceof Squat)
        {
            sList.add((Squat) fit.getCurrent());
        }


        fit.reset();
        aList = new ArrayList<>();
        while(fit.hasNext())
        {
            if(fit.getCurrent() instanceof Accesory)
            {
                aList.add((Accesory) fit.getCurrent());
            }
            fit.next();
        }
        fit.next();
        if(fit.getCurrent() instanceof Accesory)
        {
            aList.add((Accesory) fit.getCurrent());
        }

        csvWriter(filename, bpList, dlList, sList, aList);
    }   

    /** csvWriter
     * 
     * writes to the csv that is orginally passed in as input.
     * 
     * @param filename file path
     * @param bpList bench press array list
     * @param dlList deadlift array list
     * @param sList squat array list
     * @param aList accessory array list
     * 
     * https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/ refrenced how to write to a csv file. Specifically how to writeall -> with arraylist<String[]>
     * http://users.eecs.northwestern.edu/~ocg474/SIDnet/javadoc/au/com/bytecode/opencsv/CSVWriter.html refrenced for csv formatting
     * 
     * @throws IOException
     * 
     */
    public void csvWriter(String filename, ArrayList<BenchPress> bpList, 
        ArrayList<DeadLift> dlList, ArrayList<Squat> sList, ArrayList<Accesory> aList) throws IOException
    {   

            File file = new File(filename); 
            List<String[]> contents = new ArrayList<String[]>();

            CSVWriter writer = new CSVWriter(new FileWriter(file), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            String[] top = new String[] {"Date", "Workout", "Total Set Count", "Total Rep Count", "RPE", "Weight Per Set"};
            contents.add(top);

            for(BenchPress data : bpList)
            {
                String temp[] = new String[] 
                {
                    data.getDate(), 
                    data.getWorkOutName(),  
                    String.valueOf(data.getSetCount()), 
                    String.valueOf(data.getRepCount()), 
                    String.valueOf(data.getRpe())
                };
                
                ArrayList<Double> wList = data.getListofWeight();

                String line[] = new String[temp.length + wList.size()];


                for(int i = 0; i < temp.length; i++)
                {
                    line[i] = temp[i];
                }

                for (int i = 0; i < wList.size(); i++) 
                {
                     line[temp.length + i] = String.valueOf(wList.get(i));
                }

                contents.add(line);
            }

            for(DeadLift data : dlList)
            {
                String temp[] = new String[] 
                {
                    data.getDate(), 
                    data.getWorkOutName(),  
                    String.valueOf(data.getSetCount()), 
                    String.valueOf(data.getRepCount()), 
                    String.valueOf(data.getRpe())
                };
                
                ArrayList<Double> wList = data.getListofWeight();

                String line[] = new String[temp.length + wList.size()];


                for(int i = 0; i < temp.length; i++)
                {
                    line[i] = temp[i];
                }

                for (int i = 0; i < wList.size(); i++) 
                {
                     line[temp.length + i] = String.valueOf(wList.get(i));
                }

                contents.add(line);
            }

            for(Squat data : sList)
            {
               String temp[] = new String[] 
                {
                    data.getDate(), 
                    data.getWorkOutName(),  
                    String.valueOf(data.getSetCount()), 
                    String.valueOf(data.getRepCount()), 
                    String.valueOf(data.getRpe())
                };
                
                ArrayList<Double> wList = data.getListofWeight();

                String line[] = new String[temp.length + wList.size()];


                for(int i = 0; i < temp.length; i++)
                {
                    line[i] = temp[i];
                }

                for (int i = 0; i < wList.size(); i++) 
                {
                     line[temp.length + i] = String.valueOf(wList.get(i));
                }

                contents.add(line);
            }

            for(Accesory data : aList)
            {
                String temp[] = new String[] 
                {
                    data.getDate(), 
                    data.getWorkOutName(),  
                    String.valueOf(data.getSetCount()), 
                    String.valueOf(data.getRepCount()), 
                    String.valueOf(data.getRpe())
                };
                
                ArrayList<Double> wList = data.getListofWeight();

                String line[] = new String[temp.length + wList.size()];


                for(int i = 0; i < temp.length; i++)
                {
                    line[i] = temp[i];
                }

                for (int i = 0; i < wList.size(); i++) 
                {
                     line[temp.length + i] = String.valueOf(wList.get(i));
                }

                contents.add(line);
            }

            writer.writeAll(contents);
            writer.close();
    }
        
    


    /** LiftAnalysis
     * 
     * Takes lifts passed and calls all visitors on him.
     * 
     * @param accesory - passed to call visitors on accessories
     * @param benchPress - passed to call visitors on benchPress
     * @param deadLift - passed to call visitors on deadLift
     * @param squat - passed to call visitors on squat
     */
    public void LiftAnalysis(Accesory accesory, BenchPress benchPress, DeadLift deadLift, Squat squat)
    {   
            //visitors
        totalVisitor = new TotalVisitor();
        avgRpeVisitor = new AvgRpeVisitor();
        avgRepCountVisitor = new AvgRepCountVisitor();
        avgTotalVisitor = new AvgTotalVisitor();

        if(accesory != null)
        {
            totalVisitor.visit(accesory);
            avgRpeVisitor.visit(accesory);
            avgRepCountVisitor.visit(accesory);
            avgTotalVisitor.visit(accesory);
        }
        else if(benchPress != null)
        {
            totalVisitor.visit(benchPress);
            avgRpeVisitor.visit(benchPress);
            avgRepCountVisitor.visit(benchPress);
            avgTotalVisitor.visit(benchPress);
        }
        else if(squat != null)
        {
            totalVisitor.visit(squat);
            avgRpeVisitor.visit(squat);
            avgRepCountVisitor.visit(squat);
            avgTotalVisitor.visit(squat);
        }
        else if(deadLift != null)
        {
            totalVisitor.visit(deadLift);
            avgRpeVisitor.visit(deadLift);
            avgRepCountVisitor.visit(deadLift);
            avgTotalVisitor.visit(deadLift);
        }
        else
        {
            error = "Invalid type passed in";
        }
    }

    /** FowardIterator
     * 
     * @return returns forward iterator.
     * 
     */
    public ForwardIterator getForwardIterator()
    {
        return fit;
    }

    /** getFowardContainer
     * 
     * @return returns forward Container
     * 
     */
    public FowardContainer getFowardContainer()
    {
        return fContainer;
    }

    /** getAvgRepCountVisitor
     * 
     * @return returns Avg Rep Count visitor.
     */
    public AvgRepCountVisitor getAvgRepCountVisitor()
    {
        return avgRepCountVisitor;
    }

    /** getAvgRpeVisitor
     * 
     * @return returns avg rpe visitor.
     * 
     */
    public AvgRpeVisitor getAvgRpeVisitor()
    {
        return avgRpeVisitor;
    }

    /** getAvgTotalVisitor
     * 
     * @return returns avg total visitor
     * 
     */
    public AvgTotalVisitor getAvgTotalVisitor()
    {
        return avgTotalVisitor;
    }

    /** getTotalVisitor
     * 
     * @return returns total visitor.
     * 
     */
    public TotalVisitor getTotalVisitor()
    {
        return totalVisitor;
    }

    /** getError
     * 
     * @return returns error.
     */
    public String getError()
    {
        return error;
    }

    /** getHead
     * 
     * returns the head of the list
     * 
     */
    public Lift getHead()
    {
        return head;
    }

    /** getArrayListBenchPress
     * 
     * @return returns just an array list of every benchpress object
     * 
     */
    public ArrayList<BenchPress> getArrayListBenchPress()
    {
        return bpList;
    }

    /** getArrayListDeadLift
     * 
     * @return returns just an array list of every deadlift object
     */
    public ArrayList<DeadLift> getArrayListDeadlift()
    {
        return dlList;
    }

    /** getArrayListSquat
     * 
     * @return returns just an array list of every squat object
     */
    public ArrayList<Squat> getArrayListSquat()
    {
        return sList;
    }

    /** getArrayListAccesory 
     * 
     * @return returns just an array list of every accessory object.
     */
    public ArrayList<Accesory> getArrayListAccesory()
    {
        return aList;
    }

}
