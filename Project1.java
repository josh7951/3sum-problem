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
            return arr;
        }
        catch(Exception e) { return null; }
    }
    public static boolean findSum(int arr[], int arrSize, int sum){
        for(int i = 0; i < arrSize - 2; i++){
            int j = i + 1;
            int k = arrSize - 1;
            while(j < k){
                if(arr[i] + arr[j] + arr[k] == sum){
                    System.out.println(sum + " Yes");
                    return true;
                }
                else if(arr[i] + arr[j] + arr[k] < sum)
                    j++;
                else
                    k--;
            }
        }
        System.out.println(sum + " No");
        return false;
    }
    public static void main(String[] args){
        int[] numArray = readFile("input1.txt");
        int[] addArr = {15, 82, 22, 36, 29, 11, 31, 4, 31};
        int[] targetSum = {119, 9, -2, 57, 29, 73, 93}; 
        int size = addArr.length;
        Arrays.sort(addArr);
        for(int m = 0; m < targetSum.length; m++){
            int sum = targetSum[m];
            findSum(addArr, size, sum);        
        }
    }
}