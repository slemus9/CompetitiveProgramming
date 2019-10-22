package hackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TimeConversion {

    public static String militaryHour(int hh, int mm, int ss, String t){
        String newHh = hh + "";

        if (t.equals("PM")){
            int militaryh;
            if (hh != 12){
                newHh = Math.floorMod(hh + 12, 24) + "";
            }else {
                newHh = "12";
            }
        }else {
            if(hh == 12){
                newHh = "00";
            }
        }

        String newMm = mm + "";
        String newSs = ss + "";

        if (newHh.length() < 2){
            newHh = "0" + newHh;
        }
        if (newMm.length() < 2){
            newMm = "0" + newMm;
        }
        if (newSs.length() < 2){
            newSs = "0" + newSs;
        }

        return newHh + ":" + newMm + ":" + newSs;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] date = br.readLine().split(":");
        int hh = Integer.parseInt(date[0]);
        int mm = Integer.parseInt(date[1]);
        String t = date[2].substring(2);
        int ss = Integer.parseInt(date[2].substring(0, 2));

        System.out.println(militaryHour(hh, mm, ss, t));
    }
}
