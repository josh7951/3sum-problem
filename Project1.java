import java.io.File;
import java.util.*;

public class Project1 {
    //Method that will read the array from the text file
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
    //method that will search for zero in the given array from the text file
    public static int findSplit(int arr[], int key){
        if(arr == null) { return -1; }
        int length = arr.length;
        int i = 0;
        while(i < length){
            if(arr[i] == key){
                return i;
            }
            else{
                i = i + 1;
            }
        }
        return -1;
    }
    //Method that traverses the addend array and adds three unique values together
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
        int[] fileArr = readFile("input1.txt");
        int fileArrLength = fileArr.length;
        int split = findSplit(fileArr, 0);
        int[] addends = Arrays.copyOfRange(fileArr, 0, split);
        int[] targetSum = Arrays.copyOfRange(fileArr, split+1, fileArrLength);
        int size = addends.length;
        Arrays.sort(addends);
        for(int m = 0; m < targetSum.length; m++){
            int sum = targetSum[m];
            findSum(addends, size, sum);        
        }
    }
}