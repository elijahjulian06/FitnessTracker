package gymtracker;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;



public class App extends JFrame 
{

    public static CsvReaderWriter reader;
    public static FowardContainer fContainer;
    public static ForwardIterator fit;

    public static ArrayList<BenchPress> bpList;
    public static ArrayList<DeadLift> dlList;
    public static ArrayList<Squat> sList;
    public static ArrayList<Accesory> aList;

    public static TotalVisitor totalVisitor;
    public static AvgRepCountVisitor avgRepCountVisitor;
    public static AvgRpeVisitor avgRpeVisitor;
    public static AvgTotalVisitor avgTotalVisitor;

    private JTextArea resultText;


    /**
     * Demo app to demostrate gym tracker
     * Referenced 2440 calculator lab.
     * Referenced this tutorial - https://www.guru99.com/java-swing-gui.html -- general gui know how.
     * Refrenced this tutorial - https://gist.github.com/sfcgeorge/83027af0338c7c34adf8 -- for the buttons.
     * 
     */
    public App() 
    {
        setTitle("Gym Tracker");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        resultText = new JTextArea();
        resultText.setRows(5);

        JButton totalWorkoutsButton = new JButton("Total Workouts");
        JButton averageWeightButton = new JButton("Average Weight");
        JButton averageRepCountButton = new JButton("Average Rep Count");
        JButton averageRpeButton = new JButton("Average RPE");
        JButton accesoryDescription = new JButton("Accessory");
        JButton benchPressDescription = new JButton("BenchPress");
        JButton deadLiftDescription = new JButton("DeadLift");
        JButton squatDescription = new JButton("Squat");

        add(totalWorkoutsButton);
        add(averageWeightButton);
        add(averageRepCountButton);
        add(averageRpeButton);
        add(benchPressDescription);
        add(deadLiftDescription);
        add(squatDescription);
        add(accesoryDescription);

        add(new JLabel("Results:"));
        add(new JScrollPane(resultText));

        totalWorkoutsButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String result = totalVisitor.printTotal();
                resultText.setText(result);
            }
        });

        averageWeightButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String result = avgTotalVisitor.printAvgWeight();
                resultText.setText(result);
            }
        });

        averageRepCountButton.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String result = avgRepCountVisitor.printRepCount();
                resultText.setText(result);
            }
        });

        averageRpeButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String result = avgRpeVisitor.printAvgRpe();
                resultText.setText(result);
            }
        });

        benchPressDescription.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String result = "";
                for(BenchPress data : bpList)
                {
                    result += data.printSet();
                    result += "\n";
                }
                resultText.setText(result);
            } 
        });

        deadLiftDescription.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String result = "";
                for(DeadLift data : dlList)
                {
                    result += data.printSet();
                    result += "\n";
                }
                resultText.setText(result);
            }
        });

        squatDescription.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String result = "";
                for(Squat data : sList)
                {
                    result += data.printSet();
                    result += "\n";
                }
                resultText.setText(result);
            }
        });

        accesoryDescription.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String result = "";
                for(Accesory data : aList)
                {
                    result += data.printSet();
                    result += "\n";
                }
                resultText.setText(result);
            }
        });

        
    }

    public static void main(String[] args) throws IOException 
    {
        /** 
        FowardContainer testContainer = new FowardContainer();
        BenchPress lift1 = new BenchPress(null, null, 1, 0, 0);
        BenchPress lift2 = new BenchPress(null, null, 2, 0, 0);
        BenchPress lift3 = new BenchPress(null, null, 3, 0, 0);
        testContainer.addNextLift(lift1);
        testContainer.addNextLift(lift2);
        testContainer.addNextLift(lift3);

        ForwardIterator testIterator = (ForwardIterator) testContainer.getIterator(lift1);

        System.out.println(testIterator.getCurrent().getSetCount());
        System.out.println(testIterator.hasNext());
        testIterator.next();
        System.out.println(testIterator.getCurrent().getSetCount());

        testIterator.reset();

        System.out.println(testIterator.getCurrent().getSetCount());
        System.out.println(testIterator.hasNext());
        testIterator.next();
        System.out.println(testIterator.getCurrent().getSetCount());
        */
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Please put a path to csv file: ");
        String path = sc.nextLine();

        //temp path
        //String path = "/Users/elijahjulian/Desktop/finalproject/final-project-elijahjulian06/app/build/resources/main/ElisWorkout.csv";

        reader = new CsvReaderWriter();
        ArrayList<String> raw = reader.readCSV(path);

        reader.buildList(raw);

        fContainer = reader.getFowardContainer();
        fit = reader.getForwardIterator();

        reader.organizeLifts(path, fit);

        bpList = reader.getArrayListBenchPress();
        dlList = reader.getArrayListDeadlift();
        sList = reader.getArrayListSquat();
        aList = reader.getArrayListAccesory();
        
        totalVisitor = reader.getTotalVisitor();
        avgRepCountVisitor = reader.getAvgRepCountVisitor();
        avgRpeVisitor = reader.getAvgRpeVisitor();
        avgTotalVisitor = reader.getAvgTotalVisitor();

        App app = new App();
        app.setVisible(true);

    }
}

