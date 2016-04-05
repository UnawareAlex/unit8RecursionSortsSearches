import java.util.Arrays;

public class BubbleSort
{
    public BubbleSort(int[] a)
    {
        boolean sorted = true;
    
        for (int i = 0; i < a.length - 1; i++) 
        {
            if (a[i] > a[i+1]) 
            {
                sorted = false;
                break;
            }
        }
        
        while (sorted == false)
        {
            for (int i = 0; i < a.length - 1; i++)
            {
                if (a[i] > a[i+1])
                {
                    
                }
            }
        }
    }
}
