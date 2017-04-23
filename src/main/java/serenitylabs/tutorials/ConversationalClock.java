package serenitylabs.tutorials;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

public class ConversationalClock {

    private final SystemTime now;

    private final String prefix = "it's ";

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    public String currentTime() {

        int hour = now.hour();

        String hourString = "";

        switch (hour) {
            case 0: hourString = "midnight";
                break;
            case 1: hourString = "one";
                break;
            case 2: hourString = "two";
                break;
            case 3: hourString = "three";
                break;
            case 4: hourString = "four";
                break;
            case 5: hourString = "five";
                break;
            case 6: hourString = "six";
                break;
            case 7: hourString = "seven";
                break;
            case 8: hourString = "eight";
                break;
            case 9: hourString = "nine";
                break;
            case 10: hourString = "ten";
                break;
            case 11: hourString = "eleven";
                break;
            case 12: hourString = "noon";
                break;
            case 13: hourString = "one";
                break;
            case 14: hourString = "two";
                break;
            case 15: hourString = "three";
                break;
            case 16: hourString = "four";
                break;
            case 17: hourString = "five";
                break;
            case 18: hourString = "six";
                break;
            case 19: hourString = "seven";
                break;
            case 20: hourString = "eight";
                break;
            case 21: hourString = "nine";
                break;
            case 22: hourString = "ten";
                break;
            case 23: hourString = "eleven";
                break;
        }

        RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat( new Locale("EN", ""), RuleBasedNumberFormat.SPELLOUT );

        String minuteString = ruleBasedNumberFormat.format(now.minute()).replace("-", " ");

        if (now.minute() == 0) {
            if (hour != 12 && hour != 0) {
                return prefix + hourString + " o'clock";
            } else {
                return prefix + hourString;
            }
        } else {
            return prefix + minuteString + " past " + hourString;
        }

    }



}
