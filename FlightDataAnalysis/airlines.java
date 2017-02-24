package ccproject;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public class airlines
{
    /* member class not found */
    class Map1 {}

    /* member class not found */
    class Map2 {}

    /* member class not found */
    class Map3 {}

    /* member class not found */
    class MultiFileOutput1 {}

    /* member class not found */
    class MultiFileOutput2 {}

    /* member class not found */
    class MultiFileOutput3 {}

    /* member class not found */
    class Reduce1 {}

    /* member class not found */
    class Reduce2 {}

    /* member class not found */
    class Reduce3 {}


    public airlines()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        JobConf conf = new JobConf(ccproject/airlines);
        conf.setJobName("airlines");
        conf.setOutputKeyClass(org/apache/hadoop/io/Text);
        conf.setOutputValueClass(org/apache/hadoop/io/IntWritable);
        conf.setMapperClass(ccproject/airlines$Map1);
        conf.setReducerClass(ccproject/airlines$Reduce1);
        conf.setInputFormat(org/apache/hadoop/mapred/TextInputFormat);
        conf.setOutputFormat(ccproject/airlines$MultiFileOutput1);
        FileInputFormat.setInputPaths(conf, new Path[] {
            new Path(args[0])
        });
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
        JobClient.runJob(conf);
        JobConf conf2 = new JobConf(ccproject/airlines);
        conf2.setJobName("airlines");
        conf2.setOutputKeyClass(org/apache/hadoop/io/Text);
        conf2.setOutputValueClass(org/apache/hadoop/io/IntWritable);
        conf2.setMapperClass(ccproject/airlines$Map2);
        conf2.setReducerClass(ccproject/airlines$Reduce2);
        conf2.setOutputFormat(ccproject/airlines$MultiFileOutput2);
        FileInputFormat.setInputPaths(conf2, new Path[] {
            new Path(args[0])
        });
        FileOutputFormat.setOutputPath(conf2, new Path(args[2]));
        JobClient.runJob(conf2);
        JobConf conf3 = new JobConf(ccproject/airlines);
        conf3.setJobName("airlines");
        conf3.setOutputKeyClass(org/apache/hadoop/io/Text);
        conf3.setOutputValueClass(org/apache/hadoop/io/IntWritable);
        conf3.setMapperClass(ccproject/airlines$Map3);
        conf3.setReducerClass(ccproject/airlines$Reduce3);
        conf3.setOutputFormat(ccproject/airlines$MultiFileOutput3);
        FileInputFormat.setInputPaths(conf3, new Path[] {
            new Path(args[0])
        });
        FileOutputFormat.setOutputPath(conf3, new Path(args[3]));
        JobClient.runJob(conf3);
    }
}