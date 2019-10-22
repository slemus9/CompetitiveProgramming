package MUA.semester1.s1.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndHisSociety1 {

    public static int sum(int[] arr, int m){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num - m <= 0){
                sum += 0;
            }else {
                sum += num - m;
            }
        }
        return sum;
    }

    public static int[] searchMinM(int n, int th, int[] arr){
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }

        int[] searchArr = new int[max];
        int s = 0;
        int m = 0;
        int i = 0;
        int j = max;
        boolean found = false;

        while (i <= j && !found){
            m = (i + j)/2;
            s = sum(arr, m);
            searchArr[m] = s;
            if (s > th){
                i = m + 1;
            }else if(s < th){
                j = m - 1;
            }else {
                found = true;
            }
        }

        int[] ans = new int[2];

        if (!found){
            ans[0] = j;
            ans[1] = searchArr[j];
        }else {
            ans[0] = m;
            ans[1] = searchArr[m];
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < t; i++) {
            String[] data = br.readLine().trim().split(" ");
            int n = Integer.parseInt(data[0]);
            int th = Integer.parseInt(data[1]);
            String[] nums = br.readLine().trim().split(" ");
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(nums[j]);
            }

            int[] ans = searchMinM(n, th, arr);
            System.out.println(ans[0] + " " + ans[1]);

        }
    }
}
