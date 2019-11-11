package MUA.exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4719
 */
public class AutomatedCheckingMachine{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        while (line != null){

            String  b1 = line.replaceAll("\\s","");
            String b2 = br.readLine().replaceAll("\\s","");
            boolean compatible = true;

            for (int i = 0; i < b1.length() && compatible; i++) {
                int x = Integer.parseInt(b1.charAt(i) + "");
                int y = Integer.parseInt(b2.charAt(i) + "");
                compatible = (x ^ y) == 1;
            }

            if (compatible) System.out.println("Y");
            else System.out.println("N");

            line = br.readLine();
        }
    }
}
