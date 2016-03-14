import java.util.*;

public class ListMethods
{
    public static ArrayList<Integer> makeList(int n)
    {
        ArrayList<Integer> tempList = null;
        if (n <= 0)  // The smallest list we can make
        {
            tempList = new ArrayList<Integer>();
        }
        else        // All other size lists are created here
        {
            tempList = makeList(n-1); //Solve smaller problem
            tempList.add(n);          //use it to solve larger problem
            return tempList;
        }
        return tempList;
    }
   
    public static ArrayList<Integer> reverseList(ArrayList<Integer> tList) 
    {
        ArrayList<Integer> list = ListMethods.deepClone(tList); 
        if ((list.size() <= 1) || (list.size() == 0))
        {
            return list;
        }
        else
        {
            Integer tempInt = list.remove(0);
            list = ListMethods.reverseList(list);
            list.add(tempInt);
        }
        return list;
    }
   
    public static ArrayList<Integer> even(ArrayList<Integer> tList)
    {
        ArrayList<Integer> list = ListMethods.deepClone(tList);
        if ((list.size() == 0) || (list.size() == 1))
        {
            return list;
        }
        else
        {
            Integer tempInt = list.remove(0);
            list.remove(0); // Throw away the second element
            list = ListMethods.reverseList(list);
            list.add(tempInt);
        }
        return list;
    }
    
    public static ArraList<Integer> merge(ArrayList<Integer> tList1, ArrayList<Integer> tList2)
    {
        ArraList<Integer> list1 = ListMethods.deepClone(tList1);
        ArraList<Integer> list2 = ListMethods.deepClone(tList2);
        ArrayList<Integer> tempList;  // The list we will return
        
        if (list1.size()
    }
   
    public static ArrayList<Integer> deepClone(ArrayList<Integer> tList)
    {
      ArrayList<Integer> list = new ArrayList<Integer>(); 
      for (Integer i : tList)
      {
           list.add(new Integer(i));
      }
      return list;
    }
}