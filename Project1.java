import java.io.File;
import java.util.*;

public class Project1 {
    public static int[] readFile(String file){
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
                s1.close();
                Arrays.sort(arr); //Array Sort is O(nlogn)
            return arr;
        }
        catch(Exception e) { return null; }
    }
    public static void main(String[] args){
        int[] numArray = readFile("input1.txt");
        for(int i = 0; i < numArray.length - 2; i++){
            int j = i + 1;
            int k = numArray.length - 1;
            while(j < k){
                int sum = numArray[j] + numArray[k] + numArray[i];
                int test = 2;
                if (sum == test)
                    System.out.println(i+":"+ numArray[i] +", "+j+":"+ numArray[j]+", "+k+":"+ numArray[k]);
                /* if(sum > 0)
                    k--;
                else if(sum < 0)
                    j++; */
                else 
                    System.out.println("No Solution");
            }
        }
    }
}