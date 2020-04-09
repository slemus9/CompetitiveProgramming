package MUA.S201901.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RightLeftCipher {

    public static String decipher(String s){

        int n = s.length();

        if (n < 3){
            return s;
        }

        int i = 0;
        int j = 0;

        if (n % 2 == 0){
            i = n - 1;
        } else{
            j = n - 1;
        }

        String originalString = "";

        while (originalString.length() < s.length()){

            originalString = s.charAt(i) + originalString;
            if (i != j){
                originalString = s.charAt(j) + originalString;
            }

            if (n % 2 == 0){
                i--;
                j++;
            }else {
                i++;
                j--;
            }
        }

        return originalString;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(decipher(br.readLine()));
    }
}
