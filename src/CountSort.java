import java.util.Arrays;
import java.util.Scanner;



public class CountSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.print("Enter the elements : ");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(findCountArray(arr)));
    }
    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    public static int[] findCountArray(int[] array){
        int Max_value = findMax(array);
        int[] count = new int[Max_value+1];
        int[] ans = new int[array.length];
        for(int i=0;i<array.length;i++){
            count[array[i]]++;
        }
        for(int i=1;i<=Max_value;i++){
            count[i] = count[i]+count[i-1];
        }
        for(int i=0;i<array.length;i++){
            ans[count[array[i]]-1] = array[i];
            count[array[i]]--;
        }
        return ans;
    }
}
