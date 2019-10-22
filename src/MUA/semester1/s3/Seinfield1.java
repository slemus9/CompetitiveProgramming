package MUA.semester1.s1.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Seinfield1 {

    public static int getOpsToStabilize(String s){

        if (s.length() % 2 != 0){
            return 0;
        }

        Stack stack = new Stack();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty()){
                if (c == '}'){
                    count++;
                    stack.push('{');
                }else {
                    stack.push(c);
                }
            }else {
                if (c == '}'){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }

        int leftInStack = 0;
        while (!stack.empty()){
            stack.pop();
            leftInStack ++;
        }
        count += leftInStack / 2;

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int i = 1;

        while (s.charAt(0) != '-'){
            System.out.println(i + ". " + getOpsToStabilize(s));
            s = br.readLine();
            i++;
        }
    }
}
