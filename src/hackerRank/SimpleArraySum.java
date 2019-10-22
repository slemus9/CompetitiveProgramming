package hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleArraySum {

    public static int arraySum(int[] arr){
        int r = 0;
        for (int n: arr) {
            r += n;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        System.out.println(arraySum(arr));
    }

}
