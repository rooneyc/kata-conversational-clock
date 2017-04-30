package serenitylabs.tutorials;

import static serenitylabs.tutorials.TimePhrases.midnight;
import static serenitylabs.tutorials.TimePhrases.noon;

class HourTranslator {

    String wordForHour(int hour) {

        String hourString = "";

        if (midnight(hour)) {
            hourString = "midnight";
        }
        if (hour == 1 || hour == 13) {
            hourString = "one";
        }
        if (hour == 2 || hour == 14) {
            hourString = "two";
        }
        if (hour == 3 || hour == 15) {
            hourString = "three";
        }
        if (hour == 4 || hour == 16) {
            hourString = "four";
        }
        if (hour == 5 || hour == 17) {
            hourString = "five";
        }
        if (hour == 6 || hour == 18) {
            hourString = "six";
        }
        if (hour == 7 || hour == 19) {
            hourString = "seven";
        }
        if (hour == 8 || hour == 20) {
            hourString = "eight";
        }
        if (hour == 9 || hour == 21) {
            hourString = "nine";
        }
        if (hour == 10 || hour == 22) {
            hourString = "ten";
        }
        if (hour == 11 || hour == 23) {
            hourString = "eleven";
        }
        if (noon(hour)) {
            hourString = "noon";
        }

        return hourString;
    }

}
