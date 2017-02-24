package ccproject;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

// Referenced classes of package ccproject:
//            airlines

public static class k extends MapReduceBase
    implements Reducer
{

    public void reduce(Text key, Iterator values, OutputCollector output, Reporter reporter)
        throws IOException
    {
        float sum = 0.0F;
        int count;
        for(count = 0; values.hasNext(); count++)
            sum += ((IntWritable)values.next()).get();

        average = sum / (float)count;
        String s = key.toString();
        if(f == 0)
        {
            for(int i = 0; i < 6; i++)
            {
                flights[i][1] = "0";
                flights[i][0] = " ";
            }

            f = 1;
        }
        if(s.equals(Character.toString('\376')))
        {
            for(int i = 0; i < 6; i++)
            {
                if(i == 0)
                    output.collect(new Text("Highest probabilty of airlines on schedule"), new FloatWritable());
                else
                if(i == 3)
                    output.collect(new Text("Lowest probabilty of airlines on schedule"), new FloatWritable());
                output.collect(new Text(flights[i][0]), new FloatWritable(Float.parseFloat(flights[i][1])));
            }

        } else
        if(average > Float.parseFloat(flights[0][1]))
        {
            flights[2][1] = flights[1][1];
            flights[2][0] = flights[1][0];
            flights[1][1] = flights[0][1];
            flights[1][0] = flights[0][0];
            flights[0][1] = String.valueOf(average);
            flights[0][0] = s.replace(" in", "");
        } else
        if(average > Float.parseFloat(flights[1][1]))
        {
            flights[2][1] = flights[1][1];
            flights[2][0] = flights[1][0];
            flights[1][1] = String.valueOf(average);
            flights[1][0] = s.replace(" in", "");
        } else
        if(average > Float.parseFloat(flights[2][1]))
        {
            flights[2][1] = String.valueOf(average);
            flights[2][0] = s.replace(" in", "");
        }
        if(average < Float.parseFloat(flights[3][1]) || k == 0)
        {
            flights[5][1] = flights[4][1];
            flights[5][0] = flights[4][0];
            flights[4][1] = flights[3][1];
            flights[4][0] = flights[3][0];
            flights[3][1] = String.valueOf(average);
            flights[3][0] = s.replace(" in", "");
            k = 1;
        } else
        if(average < Float.parseFloat(flights[4][1]))
        {
            flights[5][1] = flights[4][1];
            flights[5][0] = flights[4][0];
            flights[4][1] = String.valueOf(average);
            flights[4][0] = s.replace(" in", "");
        } else
        if(average < Float.parseFloat(flights[5][1]))
        {
            flights[5][1] = String.valueOf(average);
            flights[5][0] = s.replace(" in", "");
        }
    }

    public volatile void reduce(Object obj, Iterator iterator, OutputCollector outputcollector, Reporter reporter)
        throws IOException
    {
        reduce((Text)obj, (Iterator)iterator, (OutputCollector)outputcollector, reporter);
    }

    String flights[][];
    float average;
    int f;
    int k;

    public porter()
    {
        flights = new String[6][2];
        average = 0.0F;
        f = 0;
        k = 0;
    }
}