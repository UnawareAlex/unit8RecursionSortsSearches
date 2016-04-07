import java.util.Arrays;

public class BubbleSort
{
    //private boolean sorted;
    public BubbleSort()
    {
       //sorted = true;
    }
    
    public int[] sortArray(int[] a)
    {
        for (int i = 0; i < a.length - 1; i++)
        {
            if (a[i] > a[i+1]) 
            {
                for (int j = 0; j < a.length - 1; j++) 
                {
                    if (a[j] > a[j+1]) 
                    {
                        //sorted = false;
                        int holder = a[j];
                        a[j] = a[j+1];
                        a[j+1] = holder;
                    } 
                }
                i = 0;
            }
        }
        return a;
    }
    
    public static void main(String[] args)
    {
        int[] a = ArrayUtil.randomIntArray(20, 100);
        System.out.println(Arrays.toString(a));
        
        BubbleSort bubble = new BubbleSort();
        int[] sortedArray = bubble.sortArray(a);
        System.out.println(Arrays.toString(bubble.sortArray(a)));
    }
}
