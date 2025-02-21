import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataAnalyzer{
    //reverse list
    public static int[] reverseList(int[] nums){
        int[] reversed = new int[nums.length];
        int index = nums.length - 1;
        int i = 0;
        while(index > 0){
            reversed[i] = nums[index];
            i++;
            index--;
        }
        return reversed;
    }
    //Binary Search
    public static int searchList(int target, int[] nums){
        int low = 0;
        int high = nums.length;
        while(low > high){
            int mid = (int) Math.floor((low + high) / 2);
            if(target == nums[mid]){
                return mid;
            }else{
                if(target > nums[mid]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static int searchList(int[] nums, int target){
        int index = 0;
        while(index <= nums.length - 1){
            if(nums[index] == target){
                return index;
            }
            index++;
        }
        return -1;
    }

    public static int getMax(int[] nums){
        int max = nums[0];
        for(int num : nums){
            if(num > max){
                max = num;
            }
        }
        return max;
    }

    public static int getMin(int[] nums){
        int min = nums[0];
        for(int num : nums){
            if(num < min){
                min = num;
            }
        }
        return min;
    }

    public static int[] sortList(int[] nums, int order){
        // if order = 1, sorts in ascending order
        // if order = 0, sorts in descending order
        int temp;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if (nums[j] > nums[i]){
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        if(order == 1){
            return reverseList(nums);
        }
        else{
            return nums;
        }
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(searchList(nums, 5));

        int[] reversedNums = reverseList(nums);
        for(int i = 0; i < reversedNums.length; i++){
            System.out.print(reversedNums[i] + " ");
        }
        System.out.println("");

        int[] fileNums = new int[100];
        try{
            File file = new File("UNIT6-1D-ARRAYS/numbers.txt");
            Scanner scanner = new Scanner(file);
            for(int i = 0; i < 100; i++){
                fileNums[i] = scanner.nextInt();
            }
        }catch(IOException e){
            System.out.println("File not found");
        }

        //linear search
        System.out.println(searchList(fileNums, 81));

        //binary search
        System.out.println(searchList(81, fileNums));

        //reverse list
        int[] reversedFileNums = reverseList(fileNums);
        for(int i = 0; i < reversedFileNums.length - 1; i++){
            System.out.print(reversedFileNums[i] + " ");

        FileOperator file1 = new FileOperator("UNIT6-1D-ARRAYS/capacities.txt");
        int[] capacities = file1.toIntArray(30);
        for(int num : capacities){
            System.out.print(num + " ");
        }

        System.out.println("");
        System.out.println(getMax(capacities));
        System.out.println(getMin(capacities));
        int[] orderedCapacities = sortList(capacities, 1);
    }
}
