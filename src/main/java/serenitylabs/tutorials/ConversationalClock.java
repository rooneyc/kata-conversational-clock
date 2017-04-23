package serenitylabs.tutorials;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.util.Locale;

public class ConversationalClock {

    private final SystemTime now;

    private final String prefix = "it's ";

    public ConversationalClock(SystemTime time) {
        this.now = time;
    }

    String currentTime() {

        int hour = now.hour();

        int minute = now.minute();

        if (minute == 0) {
            String suffix = "";
            if (hour != 12 && hour != 0) {
                suffix = " o'clock";
            }
            return  prefix + spellOutHour(hour) + suffix;
        } else {
            if (minute <= 30) {
                return prefix + spellOutMinutes(minute) + " past " + spellOutHour(hour);
            } else {
                return prefix + spellOutMinutes(60-minute) + " to " + spellOutHour(hour+1);
            }
        }
    }

    private String spellOutMinutes(int minute) {

        String minuteString;

        if (minute == 15) {
            minuteString = "a quarter";
        } else if (minute == 30) {
            minuteString = "half";
        } else {
            minuteString = spellOutInt(minute);
        }

        return minuteString;
    }

    private String spellOutInt(int intPrimitive) {

        String minuteString;RuleBasedNumberFormat ruleBasedNumberFormat
                = new RuleBasedNumberFormat( new Locale("EN", ""), RuleBasedNumberFormat.SPELLOUT );

        String minuteStringWithHyphens = ruleBasedNumberFormat.format(intPrimitive);

        minuteString = minuteStringWithHyphens.replace("-", " ");

        return minuteString;
    }

    private String spellOutHour(int hour) {

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

        return hourString;

    }

}
