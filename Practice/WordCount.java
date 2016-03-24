import java.util.Scanner;
import java.io.File;
import java.io.*;

public class WordCount
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter a file name to read from: ");
        File file = new File(s.next());
        
        try
        {
            Scanner in = new Scanner(file);
            int lineCount = 0;
            while (in.hasNext()) //lines
            {   
                lineCount++;
                in.nextLine();
            }
            System.out.println(lineCount);
            in.close();  
            
            Scanner in2 = new Scanner(file);
            int wordCount = 0;
            while (in2.hasNext()) 
            {   
                wordCount++;
                System.out.println(in2.next());
                //in2.next();
            }
            System.out.println(wordCount);
            in2.close();  
            
            Scanner in3 = new Scanner(file);
            in3.useDelimiter("");
            int charCount = 0;
            while (in3.hasNext()) 
            {   
                wordCount++;
                System.out.println(in3.next());
                //in2.next();
            }
            System.out.println(charCount);
            in3.close();
        }
        catch(IOException exception)
        {
            System.out.println("ERROR");
        }
    }
}