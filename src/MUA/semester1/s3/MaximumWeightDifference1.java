package MUA.semester1.s1.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumWeightDifference1 {

    public static long diff(long[] nums, int n, int k, boolean kFirst){
        long sumFather = 0;
        long sumChild = 0;
        int childUntil = 0;

        if (kFirst){
            childUntil = k;
        }else{
            childUntil = n - k;
        }

        for (int j = 0; j < childUntil; j++) {
            sumChild += nums[j];
        }

        for (int j = childUntil; j < n; j++) {
            sumFather += nums[j];
        }

        return sumFather - sumChild;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String[] arr = br.readLine().split(" ");
            long[] nums = new long[arr.length];

            for (int j = 0; j < arr.length; j++) {
                nums[j] = Long.parseLong(arr[j]);
            }

            Arrays.sort(nums);

            long diffKFirst = diff(nums, n, k, true);
            long diffKLast = diff(nums, n, k, false);

            System.out.println(Math.max(diffKFirst, diffKLast));
         }

    }
}
