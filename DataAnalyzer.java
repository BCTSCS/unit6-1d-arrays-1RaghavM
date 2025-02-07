public class DataAnalyzer {
    
    
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
        int[] arr = {10,20,30,40,50};
        System.out.println(searchList(arr, 50));
        System.out.println(binarySearch(50, arr));
    }
}