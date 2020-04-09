package MUA.S201901.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ClosestNumbers1 {

    public static ArrayList<Integer> minDiff(int[] nums){
        int minD = Integer.MAX_VALUE;
        ArrayList<Integer> candidates = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            int currentDiff = Math.abs(nums[i - 1]  - nums[i]);
            if (currentDiff < minD){
                minD = currentDiff;
                candidates = new ArrayList<>();
                candidates.add(nums[i - 1]);
                candidates.add(nums[i]);
            }else if(currentDiff == minD){
                candidates.add(nums[i - 1]);
                candidates.add(nums[i]);
            }
        }
        return candidates;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(nums);

        ArrayList<Integer> pairs = minDiff(nums);
        System.out.print(pairs.get(0));
        for (int i = 1; i < pairs.size(); i++) {
            System.out.print(" " + pairs.get(i));
        }
    }
}
