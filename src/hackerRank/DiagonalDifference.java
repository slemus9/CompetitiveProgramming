package hackerRank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiagonalDifference {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i = 0;
        int j = n - 1;
        int sumDiag1 = 0;
        int sumDiag2 = 0;
        while (i < n) {
            String[] row = br.readLine().split(" ");
            sumDiag1 += Integer.parseInt(row[i]);
            sumDiag2 += Integer.parseInt(row[j]);
            i++;
            j--;
        }
        System.out.println(Math.abs(sumDiag1 - sumDiag2));
    }
}
