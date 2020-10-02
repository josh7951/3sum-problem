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
        //int[] addVal = {15, 82, 22, 36, 29, 11, 31, 4, 31};
        int[] addVal = {1, 2, 3, 0};
        Arrays.sort(addVal);
        //int[] targetVal = {119, 9, -2, 57, 29, 73, 93}; 
        int[] targetVal = {3, 4, 6, 10, 12};
        for(int i = 0; i < addVal.length - 1; i++){
            if( i !=0 && addVal[i] == addVal[i -1]) continue;
            int j = i + 1;
            int k = addVal.length - 1;
            int sum = addVal[i] + addVal[j] + addVal[k];
            for(int m = 0; m < targetVal.length; m++){
                int sumCheck = targetVal[m];
                if(sumCheck == sum)
                    System.out.println(sumCheck + " Yes");
                else{
                    System.out.println(sumCheck + " No");
                }
            }
        }
    }
}
