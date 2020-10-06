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
    //method that will search for int 0 in the given array from the text file
    //and return its index position
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
    //and checks to see if sums are equal
    public static boolean findSum(int arr[], int arrSize, int sum){
        for(int i = 0; i < arrSize - 2; i++){
            int j = i + 1; //initalize left
            int k = arrSize - 1; //initialize right
            while(j < k){
                if(arr[i] + arr[j] + arr[k] == sum){
                    System.out.println(sum + " Yes");
                    return true;
                }
                else if(arr[i] + arr[j] + arr[k] < sum)
                    j++; //increment from the left 
                else
                    k--; //decrement from the right
            }
        }
        System.out.println(sum + " No");
        return false;
    }
    public static void main(String[] args){
        int[] fileArr = readFile("input1.txt");
        int fileArrLength = fileArr.length;
        int split = findSplit(fileArr, 0);
        //makes a copy of the array from start to index at '0'
        int[] addends = Arrays.copyOfRange(fileArr, 0, split);
        //makes a copy of the array from one spot after index at '0' to the end
        int[] sumArr = Arrays.copyOfRange(fileArr, split+1, fileArrLength);
        int size = addends.length;
        Arrays.sort(addends);
        //iterates through to compare targetSum to actual sum of different 3 value combos
        for(int m = 0; m < sumArr.length; m++){
            int targetSum = sumArr[m];
            findSum(addends, size, targetSum);        
        }
    }
}