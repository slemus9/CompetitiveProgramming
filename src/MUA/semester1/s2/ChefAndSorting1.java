package MUA.semester1.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChefAndSorting1 {

    public static int endSort(int[] ns){
        int count = 0;
        int[] nums = new int[ns.length];

        for (int i = 0; i < ns.length; i++) {
            nums[i] = ns[i];
        }

        Arrays.sort(ns);

        int i = 0;
        int j = 0;

        while (i < nums.length){
            if (nums[i] != ns[j]){
                count++;
            }else {
                j++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            String[] s = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(s[j]);
            }
            System.out.println(endSort(nums));
        }
    }
}
