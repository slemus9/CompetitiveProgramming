package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinMaxSum {

    public static long maxSum(long[] arr){
        long max = 0;
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if(i != j){
                    sum += arr[j];
                }
            }
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }

    public static long minSum(long[] arr){
        long min = Long.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if(i != j){
                    sum += arr[j];
                }
            }
            if (sum < min){
                min = sum;
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        long[] nums = new long[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = Long.parseLong(arr[i]);
        }

        long min = minSum(nums);
        long max = maxSum(nums);
        System.out.println(min + " " + max);
    }
}
