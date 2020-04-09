package MUA.S201901.s1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FancyQuotes {

    public static String getFancy(String[] words){

        boolean found = false;

        for (int i = 0; i < words.length && !found; i++) {
            if (words[i].length() == 3){
                if (words[i].equals("not")){
                    found = true;
                }
            }
        }

        if (found){
            return "Real Fancy";
        }else {
            return "regularly fancy";
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] words = br.readLine().split(" ");
            System.out.println(getFancy(words));
        }
    }
}
