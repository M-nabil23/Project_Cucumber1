package org.example.utilities;

public class BrowserUtils {


    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int convertStringToInt(String text) {
// example    String ss="1032$aqwert";
        String value = text.replaceAll("[^0-9]","");
        return Integer.parseInt(value);
    }




    public static int randomNum(int min, int max) {
//        int min = 50;
//        int max = 100;
        //Generate random int value from 50 to 100

        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }
}
