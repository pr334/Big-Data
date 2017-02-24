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
        String key2 = "";
        String value1 = "";
        String value2 = "";
        int count = 0;
        int i = 0;
        for(int length = line.length(); i < length && f == 0; i++)
        {
            char c = line.charAt(i);
            if(c == ',')
                count++;
            char k1;
            for(; i < length && count == 16; key1 = (new StringBuilder(String.valueOf(key1))).append(k1).toString())
            {
                k1 = line.charAt(++i);
                if(k1 != ',')
                    continue;
                count++;
                break;
            }

            char k2;
            for(; i < length && count == 17; key2 = (new StringBuilder(String.valueOf(key2))).append(k2).toString())
            {
                k2 = line.charAt(++i);
                if(k2 != ',')
                    continue;
                count++;
                break;
            }

            char v1;
            for(; i < length && count == 19; value1 = (new StringBuilder(String.valueOf(value1))).append(v1).toString())
            {
                v1 = line.charAt(++i);
                if(v1 != ',')
                    continue;
                count++;
                break;
            }

            char v2;
            for(; i < length && count == 20; value2 = (new StringBuilder(String.valueOf(value2))).append(v2).toString())
            {
                v2 = line.charAt(++i);
                if(v2 != ',')
                    continue;
                count++;
                if(!value1.matches("[A-Za-z]+"))
                    output.collect(new Text((new StringBuilder(String.valueOf(key1))).append(" in").toString()), new IntWritable(Integer.parseInt(value1)));
                if(!value2.matches("[A-Za-z]+"))
                    output.collect(new Text((new StringBuilder(String.valueOf(key2))).append(" out").toString()), new IntWritable(Integer.parseInt(value2)));
                f = 1;
                break;
            }

        }

        f = 0;
        if(k == 0)
        {
            String s = Character.toString('\376');
            output.collect(new Text(s), new IntWritable(0));
            k++;
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