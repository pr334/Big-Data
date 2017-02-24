package ccproject;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

// Referenced classes of package ccproject:
//            airlines

public static class l extends MapReduceBase
    implements Reducer
{

    public void reduce(Text key, Iterator values, OutputCollector output, Reporter reporter)
        throws IOException
    {
        float sum = 0.0F;
        int count;
        for(count = 0; values.hasNext(); count++)
            sum += ((IntWritable)values.next()).get();

        if(f == 0)
        {
            for(int i = 0; i < 12; i++)
            {
                taxi[i][1] = "0";
                taxi[i][0] = " ";
            }

            f = 1;
        }
        average = sum / (float)count;
        String s = key.toString();
        if(s.contains(" in"))
        {
            if(average > Float.parseFloat(taxi[0][1]))
            {
                taxi[2][1] = taxi[1][1];
                taxi[2][0] = taxi[1][0];
                taxi[1][1] = taxi[0][1];
                taxi[1][0] = taxi[0][0];
                taxi[0][1] = String.valueOf(average);
                taxi[0][0] = s.replace(" in", "");
            } else
            if(average > Float.parseFloat(taxi[1][1]))
            {
                taxi[2][1] = taxi[1][1];
                taxi[2][0] = taxi[1][0];
                taxi[1][1] = String.valueOf(average);
                taxi[1][0] = s.replace(" in", "");
            } else
            if(average > Float.parseFloat(taxi[2][1]))
            {
                taxi[2][1] = String.valueOf(average);
                taxi[2][0] = s.replace(" in", "");
            }
            if(average < Float.parseFloat(taxi[3][1]) || k == 0)
            {
                taxi[5][1] = taxi[4][1];
                taxi[5][0] = taxi[4][0];
                taxi[4][1] = taxi[3][1];
                taxi[4][0] = taxi[3][0];
                taxi[3][1] = String.valueOf(average);
                taxi[3][0] = s.replace(" in", "");
                k = 1;
            } else
            if(average < Float.parseFloat(taxi[4][1]))
            {
                taxi[5][1] = taxi[4][1];
                taxi[5][0] = taxi[4][0];
                taxi[4][1] = String.valueOf(average);
                taxi[4][0] = s.replace(" in", "");
            } else
            if(average < Float.parseFloat(taxi[5][1]))
            {
                taxi[5][1] = String.valueOf(average);
                taxi[5][0] = s.replace(" in", "");
            }
        } else
        if(s.contains(" out"))
        {
            if(average > Float.parseFloat(taxi[6][1]))
            {
                taxi[8][1] = taxi[7][1];
                taxi[8][0] = taxi[7][0];
                taxi[7][1] = taxi[6][1];
                taxi[7][0] = taxi[6][0];
                taxi[6][1] = String.valueOf(average);
                taxi[6][0] = s.replace(" out", "");
            } else
            if(average > Float.parseFloat(taxi[7][1]))
            {
                taxi[8][1] = taxi[7][1];
                taxi[8][0] = taxi[7][0];
                taxi[7][1] = String.valueOf(average);
                taxi[7][0] = s.replace(" out", "");
            } else
            if(average > Float.parseFloat(taxi[8][1]))
            {
                taxi[8][1] = String.valueOf(average);
                taxi[8][0] = s.replace(" out", "");
            }
            if(average < Float.parseFloat(taxi[9][1]) || l == 0)
            {
                taxi[11][1] = taxi[10][1];
                taxi[11][0] = taxi[10][0];
                taxi[10][1] = taxi[9][1];
                taxi[10][0] = taxi[9][0];
                taxi[9][1] = String.valueOf(average);
                taxi[9][0] = s.replace(" out", "");
                l = 1;
            } else
            if(average < Float.parseFloat(taxi[10][1]))
            {
                taxi[11][1] = taxi[10][1];
                taxi[11][0] = taxi[10][0];
                taxi[10][1] = String.valueOf(average);
                taxi[10][0] = s.replace(" out", "");
            } else
            if(average < Float.parseFloat(taxi[11][1]))
            {
                taxi[11][1] = String.valueOf(average);
                taxi[11][0] = s.replace(" out", "");
            }
        }
        if(s.equals(Character.toString('\376')))
        {
            for(int i = 0; i < 12; i++)
            {
                if(i == 0)
                    output.collect(new Text("Airports with Longest taxi-in"), new FloatWritable());
                else
                if(i == 3)
                    output.collect(new Text("Airports with Shortest taxi-in"), new FloatWritable());
                else
                if(i == 6)
                    output.collect(new Text("Airports with Longest taxi-out"), new FloatWritable());
                else
                if(i == 9)
                    output.collect(new Text("Airports with Shortest taxi-out"), new FloatWritable());
                output.collect(new Text(taxi[i][0]), new FloatWritable(Float.parseFloat(taxi[i][1])));
            }

        }
    }

    public volatile void reduce(Object obj, Iterator iterator, OutputCollector outputcollector, Reporter reporter)
        throws IOException
    {
        reduce((Text)obj, (Iterator)iterator, (OutputCollector)outputcollector, reporter);
    }

    String taxi[][];
    float average;
    int f;
    int k;
    int l;

    public porter()
    {
        taxi = new String[12][2];
        average = 0.0F;
        f = 0;
        k = 0;
        l = 0;
    }
}