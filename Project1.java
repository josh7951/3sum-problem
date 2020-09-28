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
                //Arrays.sort(arr); //Array Sort is O(nlogn)
            return arr;
        }
        catch(Exception e) { return null; }
    }
    public static void main(String[] args){
        int[] numArray = readFile("input1.txt");
        System.out.println(Arrays.toString(numArray));
        int[] addVal = {15, 82, 22, 36, 29, 11, 31, 4, 31};
        Arrays.sort(addVal);
        int[] targetVal = {119, 9, -2, 57, 29, 73, 93}; 
        for(int v = 0; v < targetVal.length; v++){
            int targetSum = targetVal[v];
            for(int i = 0; i < addVal.length - 2; i++){
                int j = i + 1;
                int k = addVal.length - 1;
                while(j<k){
                    int sum = addVal[j] + addVal[k] + addVal[i];
                    if(sum == targetSum)
                        System.out.println(targetSum +" Yes");
                    else
                        System.out.println(targetSum + " No");
                }
            }
        }
    }

        /* for(int i = 0; i < numArray.length - 2; i++){
            int j = i + 1;
            int k = numArray.length - 1;
            while(j < k){
                int sum = numArray[j] + numArray[k] + numArray[i];
                int test = 2;
                if (sum == test)
                    System.out.println(i+":"+ numArray[i] +", "+j+":"+ numArray[j]+", "+k+":"+ numArray[k]);
                if(sum > 0)
                    k--;
                else if(sum < 0)
                    j++;
                else 
                    System.out.println("No Solution");
            } 
        } */
    
}
