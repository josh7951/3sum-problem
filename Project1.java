import java.io.File;
import java.util.*;

public class Project1 {
    public static int[] doTheThing(String file){
        try{
            File f = new File(file);
            Scanner s = new Scanner(f);
            int itr = 0;
            while(s.hasNextInt()) {
                itr++;
                s.nextInt();
            }
            s.close();
            int[] arr = new int[itr];
            Scanner s1 = new Scanner(f);

            for(int i = 0; i < arr.length; i++)
                arr[i] = s1.nextInt();
                Arrays.sort(arr);
                s1.close();
            return arr;
        }
        catch(Exception e) { return null; }
    }
    public static void main(String[] args){
        int[] txtInput = doTheThing("input.txt");
        System.out.print(Arrays.toString(txtInput));
    }
}