package ccproject;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.lib.MultipleTextOutputFormat;

// Referenced classes of package ccproject:
//            airlines

static class eTextOutputFormat extends MultipleTextOutputFormat
{

    protected String generateFileNameForKeyValue(Text key, FloatWritable value, String name)
    {
        return "Airlines";
    }

    protected volatile String generateFileNameForKeyValue(Object obj, Object obj1, String s)
    {
        return generateFileNameForKeyValue((Text)obj, (FloatWritable)obj1, s);
    }

    eTextOutputFormat()
    {
    }
}