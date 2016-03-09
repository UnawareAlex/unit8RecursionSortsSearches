import java.util.*;

public class ListMethods
{
   public static ArrayList<Integer> makeList(int n)
   {
      ArrayList<Integer> tempList = null;
      int i = n - 1;
      if (n <= 0)  // The smallest list we can make
      {
          return tempList;
      }
      else        // All other size lists are created here
      {
          tempList.add(makeList(i).get(0));
          i--;
      }
      return tempList;
   }
}