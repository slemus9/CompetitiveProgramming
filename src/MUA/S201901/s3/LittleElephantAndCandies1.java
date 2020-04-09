package MUA.S201901.s1.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LittleElephantAndCandies1 {

    public static boolean allElephantsHappy(int[] elephants, int n, int c){
        for (int i = 0; i < n; i++) {
            c -= elephants[i];
            if (c < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] nc = br.readLine().split(" ");
            int n = Integer.parseInt(nc[0]);
            int c = Integer.parseInt(nc[1]);
            String[] arr = br.readLine().split(" ");
            int[] nums = new int[n];

            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(arr[j]);
            }

            boolean allHappy = allElephantsHappy(nums, n, c);

            if (allHappy){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

        }
    }
}
