package ccproject;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

// Referenced classes of package ccproject:
//            airlines

public static class k extends MapReduceBase
    implements Mapper
{

    public void map(LongWritable key, Text value, OutputCollector output, Reporter reporter)
        throws IOException
    {
        String line = value.toString();
        String key1 = "";
        int count = 0;
        int i = 0;
        for(int length = line.length(); i < length && f == 0; i++)
        {
            char c = line.charAt(i);
            if(c == ',')
                count++;
            char k;
            for(; i < length && count == 22; key1 = (new StringBuilder(String.valueOf(key1))).append(k).toString())
            {
                k = line.charAt(++i);
                if(k != ',')
                    continue;
                count++;
                if(key1.matches("[A-Za-z]+") && !key1.equals("NA"))
                    output.collect(new Text(key1), new IntWritable(1));
                f = 1;
                break;
            }

        }

        f = 0;
        if(this.k == 0)
        {
            String s = Character.toString('\376');
            output.collect(new Text(s), new IntWritable(0));
            this.k++;
        }
    }

    public volatile void map(Object obj, Object obj1, OutputCollector outputcollector, Reporter reporter)
        throws IOException
    {
        map((LongWritable)obj, (Text)obj1, (OutputCollector)outputcollector, reporter);
    }

    int f;
    int k;

    public .Reporter()
    {
        f = 1;
        k = 0;
    }
}