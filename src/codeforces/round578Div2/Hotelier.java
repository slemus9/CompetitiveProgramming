package codeforces.round578Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hotelier {

    private static int[] hotel = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String events = br.readLine();

        int l = 0;
        int r = 9;

        for (int i = 0; i < n; i++) {
            if (events.charAt(i) == 'L'){

                boolean changed1 = false;
                for (int j = 0; j < l && !changed1; j++) {
                    if (hotel[j] == 0){
                        hotel[j] = 1;
                        changed1 = true;
                    }

                }
                if (!changed1){
                    hotel[l] = 1;
                    l ++;
                }

            }else if (events.charAt(i) == 'R'){

                boolean changed2 = false;
                for (int j = 9; j > r && !changed2; j--) {
                    if (hotel[j] == 0){
                        hotel[j] = 1;
                        changed2 = true;
                    }
                }

                if (!changed2){
                    hotel[r] = 1;
                    r--;
                }

            }else {
                int room = Integer.parseInt(events.charAt(i) + "");
                hotel[room] = 0;
            }
        }

        for (int h : hotel) {
            System.out.print(h);
        }
    }
}
