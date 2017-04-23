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
            return  prefix + spellOutHour(hour) + getSuffix(hour);
        } else {
            if (minute > 55 || minute < 5) {
                return LessThanFiveMinFromAnHour(hour, minute);
            }
            return MoreThanFiveMinFromAnHour(hour, minute);
        }
    }

    private String LessThanFiveMinFromAnHour(int hour, int minute) {
        String prefixAndHoursSeparator = "";
        if (minute > 55) {
            prefixAndHoursSeparator = "almost ";
            hour += 1;
        }
        if (minute < 5) {
            prefixAndHoursSeparator = "just after ";
        }
        return prefix + prefixAndHoursSeparator + spellOutHour(hour) + getSuffix(hour);
    }

    private String MoreThanFiveMinFromAnHour(int hour, int minute) {
        String minutesAndHoursSeparator;
        if (minute <= 30) {
            minutesAndHoursSeparator = " past ";
        } else {
            minutesAndHoursSeparator = " to ";
            hour += 1;
            minute = 60 - minute;

        }
        return prefix + spellOutMinutes(minute) + minutesAndHoursSeparator + spellOutHour(hour);
    }

    private String getSuffix(int hour) {
        if (hour != 12 && hour != 0) {
            return " o'clock";
        }
        return  "";
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

        String intString;

        RuleBasedNumberFormat ruleBasedNumberFormat
                = new RuleBasedNumberFormat( new Locale("EN", ""), RuleBasedNumberFormat.SPELLOUT );

        String intStringWithHyphens = ruleBasedNumberFormat.format(intPrimitive);

        intString = intStringWithHyphens.replace("-", " ");

        return intString;
    }

    private String spellOutHour(int hour) {

        String hourString = "";

        if (hour == 0) {
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
        if (hour == 12) {
            hourString = "noon";
        }

        return hourString;

    }

}
