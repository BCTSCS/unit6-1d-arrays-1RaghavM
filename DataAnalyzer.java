import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataAnalyzer {
    public static int[] reverseList(int[] numbers){
        for(int i = 0; i<numbers.length / 2; i++){
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length -1 - i];
            numbers[numbers.length -1 - i] = temp;
        }
        return numbers;
    }
    
    public static int searchList(int[] numbers , int target){
        int index = 0;
        while(index<=numbers.length - 1){
            
            if(numbers[index]==target){
                return index;
            }
            index ++;
        }
        
        return -1;
    }

    public static int binarySearch(int target, int[] numbers){
        int min = 0;
        int max = numbers.length -1;

        while(min <= max){
            int mid = min + (max - min) / 2;

            if(numbers[mid] == target){
                return mid;
            }

            if(numbers[mid] < target){
                min = mid +1;
            }else{
                max = mid -1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        try {
            File f = new File("numbers.txt");
            Scanner input = new Scanner(f);
            for(int i = 0; i<100; i++){
                arr[i] = input.nextInt();
            }


        } catch (IOException e) {
            System.out.println("file not found");
        }

        System.out.println(searchList(arr,32));
        int []rarr = (reverseList(arr));
        for(int i = 0; i< rarr.length; i++){
            System.out.println(rarr[i]+ " ");
        }
    }

    public int[] toIntArray(int size){
        int [] arr = new int[size];
        for(int i = 0; i<size; i++){
            arr[i] = fileReader.nextInt();
        }
        return arr;
    }
}