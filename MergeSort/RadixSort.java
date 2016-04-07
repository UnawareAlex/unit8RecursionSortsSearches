import java.util.ArrayList;

public class RadixSort
{
    private ArrayList[] buckets;
    public RadixSort()
    {
        this.buckets = new ArrayList[10];
    }
    
    public ArrayList[] sortBuckets()
    {
        return buckets;
    }
}
