package ccproject;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

// Referenced classes of package ccproject:
//            airlines

public static class max extends MapReduceBase
    implements Reducer
{

    public void reduce(Text key, Iterator values, OutputCollector output, Reporter reporter)
        throws IOException
    {
        int sum;
        for(sum = 0; values.hasNext(); sum += ((IntWritable)values.next()).get());
        String s = key.toString();
        if(s.equals(Character.toString('\376')))
        {
            output.collect(new Text("The most common reason for flights cancellations"), new FloatWritable());
            if(reason.equals("A"))
                output.collect(new Text("Carrier"), new FloatWritable(max));
            if(reason.equals("B"))
                output.collect(new Text("Weather"), new FloatWritable(max));
            if(reason.equals("C"))
                output.collect(new Text("NAS"), new FloatWritable(max));
            if(reason.equals("D"))
                output.collect(new Text("Security"), new FloatWritable(max));
        }
        if(sum > max)
        {
            max = sum;
            reason = s;
        }
    }

    public volatile void reduce(Object obj, Iterator iterator, OutputCollector outputcollector, Reporter reporter)
        throws IOException
    {
        reduce((Text)obj, (Iterator)iterator, (OutputCollector)outputcollector, reporter);
    }

    String reason;
    int max;

    public porter()
    {
        reason = "";
        max = 0;
    }
}